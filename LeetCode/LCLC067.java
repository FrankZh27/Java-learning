class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        if (len1 == 0 && len2 == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int addr = 0;
        int i = len1-1;
        int j = len2-1;
        int digit = 0;
        while(i > -1 && j > -1) {
            digit = a.charAt(i)-'0' + b.charAt(j)-'0' + addr;
            i--; j--;
            if (digit == 0 || digit == 1) {
                sb.append(Integer.toString(digit));
                addr = 0;
            }
            else if (digit == 2) {
                sb.append("0");
                addr = 1;
            }
            else {
                sb.append("1");
                addr = 1;
            }
        }
        if (i == -1 && j != -1) {
            while (j > -1) {
                digit = b.charAt(j)-'0'+addr;
                j--;
                if (digit == 0 || digit == 1) {
                    sb.append(Integer.toString(digit));
                    addr = 0;
                }
                else {
                    sb.append("0");
                    addr = 1;
                }
            }
        }
        else if (j == -1 && i != -1) {
            while(i > -1) {
                digit = a.charAt(i)-'0'+addr;
                i--;
                if (digit == 0 || digit == 1) {
                    sb.append(Integer.toString(digit));
                    addr = 0;
                }
                else {
                    sb.append("0");
                    addr = 1;
                }
            }
        }
        if (addr == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
