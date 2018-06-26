class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int rmL = 0, rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rmL++;
            }
            else if (s.charAt(i) == ')') {
                if (rmL > 0) {
                    rmL--;
                }
                else {
                    rmR++;
                }
            }
        }
        
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        DFS(set, sb, s, 0, rmL, rmR, 0);
        return new ArrayList<String>(set);
    }
    private void DFS(Set<String> set, StringBuilder sb,
                     String s, int idx, int rmL, int rmR, int open) {
        if (rmL < 0 || rmR < 0 || open < 0) {
            return;
        }
        
        if (idx == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0) {
                set.add(sb.toString());
            }
            return;
        }
        
        int len = sb.length();
        
        if (s.charAt(idx) == '(') {
            DFS(set, sb, s, idx+1, rmL-1, rmR, open);
            DFS(set, sb.append('('), s, idx+1, rmL, rmR, open+1);
        }
        else if (s.charAt(idx) == ')') {
            DFS(set, sb, s, idx+1, rmL, rmR-1, open);
            DFS(set, sb.append(')'), s, idx+1, rmL, rmR, open-1);
        }
        else{
            DFS(set, sb.append(s.charAt(idx)), s, idx+1, rmL, rmR, open);
        }
        sb.setLength(len);
        return;
        
    }
}
