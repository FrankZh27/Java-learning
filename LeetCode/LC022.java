class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        String str = "";
        gpHelper(list, str, 0, 0, n);
        return list;
    }
    public void gpHelper(List<String> ans, String str, int left, int right, int n){
        if (left == n && right == n){
            ans.add(str);
            return;
        }
        
        if (left < n){
            gpHelper(ans, str+"(", left+1, right, n);
        }
        if (right < left){
            gpHelper(ans, str+")", left, right+1, n);
        }
        
        
    }
}
