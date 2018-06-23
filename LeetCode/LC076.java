class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0 && s.length() > 0) {
            return s.substring(0,1);
        }
        int matchCount = 0;
        int count = Integer.MAX_VALUE;
        int[] tTable = new int[256];
        int[] sTable = new int[256];
        String ans = "";
        for (int i = 0; i < t.length(); i++) {
            tTable[t.charAt(i)]++;
        }
        
        int left = findNextIdx(-1, tTable, s);
        int right = left;
        if (right < s.length()) {
            sTable[s.charAt(right)]++;
            matchCount++;
        }
        
        while(right < s.length()) {
            while(right < s.length() && matchCount < t.length()) {
                right = findNextIdx(right, tTable, s);
                if (right >= s.length()) {
                    return ans;
                }
                if (++sTable[s.charAt(right)] <= tTable[s.charAt(right)]) {
                    matchCount++;
                } 
            }
            while(left <= right && matchCount == t.length()) {
                if (right - left + 1 <= count) {
                    ans = s.substring(left, right+1);
                    count = right - left + 1;
                }
                if (--sTable[s.charAt(left)] < tTable[s.charAt(left)]) {
                    matchCount--;
                }
                left = findNextIdx(left, tTable, s);
            }
            
        }
        
        return ans;
    }
    private int findNextIdx(int curr, int[] table, String s) {
        curr++;
        while (curr < s.length()) {
            if (table[s.charAt(curr)] != 0) {
                return curr;
            }
            curr++;
        }
        return curr;
    }
}
