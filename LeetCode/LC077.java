class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        combineHelper(ans, new ArrayList<Integer>(), 1, n, k);
        return ans;
    }
    
    private void combineHelper(List<List<Integer>> ans, List<Integer> list,
                          int curr, int n, int k) {
        if (list.size() == k) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = curr; i <= n; i++) {
            list.add(i);
            combineHelper(ans, list, i+1, n, k);
            list.remove(list.size()-1);
        }
        return;
    }
}
