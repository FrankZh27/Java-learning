class Solution {
    public boolean backspaceCompare(String S, String T) {
        int ptrS = S.length()-1;
        int ptrT = T.length()-1;
        int spaceS = 0, spaceT = 0;
        while (ptrS >= 0 || ptrT >=0) {
            while (ptrS >= 0 && S.charAt(ptrS) == '#') {
                spaceS++;
                ptrS--;
            }
            while (ptrS >= 0 && S.charAt(ptrS) != '#' && spaceS > 0) {
                spaceS--;
                ptrS--;
            }
            while (ptrT >= 0 && T.charAt(ptrT) == '#') {
                spaceT++;
                ptrT--;
            }
            while (ptrT >= 0 && T.charAt(ptrT) != '#' && spaceT > 0) {
                spaceT--;
                ptrT--;
            }
            if (ptrS >= 0 && ptrT >= 0 && S.charAt(ptrS) != '#' && T.charAt(ptrT) != '#') {
                if (S.charAt(ptrS) != T.charAt(ptrT)) {
                    break;
                }
                ptrS--;
                ptrT--;  
            }
            if ((ptrS < 0 && ptrT >= 0 && T.charAt(ptrT) != '#') || (ptrT < 0 && ptrS >= 0 && S.charAt(ptrS) != '#')) {
                break;
            }
        }
        return ptrS < 0 && ptrT < 0;
    }
}
