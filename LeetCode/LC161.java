class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        boolean valid = false;
        if (lenS != lenT) {
            if (lenS == lenT + 1) {
                return canDelete(s, t);
            }
            if (lenT == lenS + 1) {
                return canDelete(t, s);
            }
            return false;
        }
        return canReplace(s, t);
    }
    
    private boolean canDelete(String s, String t) {
        int idxS = 0, idxT = 0;
        int lenS = s.length(), lenT = t.length();
        while (idxS < lenS && idxT < lenT) {
            if (s.charAt(idxS) == t.charAt(idxT)) {
                idxS++;
                idxT++;
            }
            else {
                idxS++;
                break;
            }
        }
        
        while (idxS < lenS && idxT < lenT) {
            if (s.charAt(idxS) != t.charAt(idxT)) {
                return false;
            }
            idxS++;
            idxT++;
        }
        return true;
        
    }
    
    private boolean canReplace(String s, String t) {
        int idx = 0;
        int len = s.length();
        while (idx < len) {
            if (s.charAt(idx) == t.charAt(idx)) {
                idx++;
            }
            else {
                break;
            }
        }
        if (idx >= len) {
            return false;
        }
        idx++;
        
        while (idx < len) {
            if (s.charAt(idx) != t.charAt(idx)) {
                return false;
            }
            idx++;
        }
        return true;
    }
}
