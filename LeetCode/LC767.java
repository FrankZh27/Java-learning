class Solution {
    public String reorganizeString(String S) {
        int[] table = new int[26];
        for (char c:S.toCharArray()) {
            table[c-'a'] += 100;
        }
        for (int i = 0; i < 26; i++) {
            table[i] += i;
        }
        Arrays.sort(table);
        char[] ans = new char[S.length()];
        int index = 0;
        
        for (int i = 25; i >= 0; i--) {
            int count = table[i]/100;
            char c = (char)('a' + table[i] % 100);
            if (count > (S.length()+1)/2) {
                return "";
            }
            for (int j = 0; j < count; j++) {
                if (index >= S.length()) {
                    index = 1;
                }
                ans[index] = c;
                index += 2;
            }
        }
        return String.valueOf(ans);
    }
}
