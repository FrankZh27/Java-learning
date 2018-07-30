class Solution {
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        helper(list, sb, s, 0, 0);
        return list;
    }
    
    private void helper(List<String> list, StringBuilder ip, String s, int idx, int count) {
        if (count == 4) {
            if (idx == s.length()) {
                String ans = ip.delete(ip.length()-1, ip.length()).toString();
                list.add(ans);
                ip.append(".");
            }
            return;
        }
        for (int i = 0; i <= 2; i++) {
            if (idx+i >= s.length()) {
                return;
            }
            if (isValid(s.substring(idx, idx+i+1))) {
                ip.append(s.substring(idx, idx+i+1));
                ip.append(".");
                helper(list, ip, s, idx+i+1, count+1);
                ip.delete(ip.length()-i-2, ip.length());
            }
        }
        return;
    }
    
    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        if (num <= 255 && num >= 0) {
            return true;
        }
        return false;
    }
}
