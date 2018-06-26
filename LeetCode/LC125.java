class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()){
            return true;
        }
        s = s.toLowerCase();
        boolean isValid = false;
        int left = 0;
        int right = s.length()-1;
        while (left <= right) {
            while (left < s.length() && !isChar(s.charAt(left))) {
                left++;
            }
            while (right >= 0  && !isChar(s.charAt(right))) {
                right--;
            }
            if (left <= right && s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isChar(char c) {
        if ((c-'a' >= 0 && 'z'-c >= 0)
            || (c-'0' >= 0 && '9'-c >= 0)) {
            return true;
        }
        return false;
    }
}
