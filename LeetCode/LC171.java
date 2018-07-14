class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        int multi = 1;
        int n = s.length();
        for (int i = n-1; i >= 0; i--) {
            sum += (s.charAt(i) - 'A' + 1) * multi;
            multi *= 26;
        }
        return sum;
    }
}
