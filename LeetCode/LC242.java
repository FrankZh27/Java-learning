class Solution {
    public boolean isAnagram(String s, String t) {
        int[] dictionary = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            dictionary[s.charAt(i)-'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            dictionary[t.charAt(i)-'a'] -= 1;
        }
        
        for (int i = 0; i < 26; i++) {
            if (dictionary[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
