class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int sz = len1 + len2;
        int[] result = new int[sz];
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int curr = 0;
        int addr = 0;
        for (int num2Index = 0; num2Index < len2; num2Index++) {
            for (int num1Index = 0; num1Index < len1; num1Index++) {
                curr = (num1.charAt(len1-1-num1Index) - '0')
                       * (num2.charAt(len2-1-num2Index) - '0');
                result[sz-num1Index-num2Index-1] += curr;
                if (result[sz-num1Index-num2Index-1]/10 > 0) {
                    result[sz-num1Index-num2Index-2] += result[sz-num1Index-num2Index-1]/10;
                    result[sz-num1Index-num2Index-1] %= 10;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int digit = 0;
        while(result[digit] == 0) {
            digit++;
        }
        for (int i = digit; i < sz; i++) {
            sb.append(Integer.toString(result[i]));
        }
        return sb.toString();
    }
}
