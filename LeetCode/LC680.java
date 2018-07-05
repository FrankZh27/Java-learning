class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        int count = 1;
        int left = 0, right = s.length()-1;
        while(left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            else {
                if (count == 0) {
                    return false;
                }
                else {
                    String leftDelete = s.substring(left+1, right+1);
                    String rightDelete = s.substring(left, right);
                    return(validHelper(leftDelete) || validHelper(rightDelete));
                }
            }
        }
        return true;
    }
    private boolean validHelper(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
