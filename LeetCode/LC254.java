class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        getFactorsHelper(ans, new ArrayList<Integer>(), n, 2);
        return ans;
    }
    
    private void getFactorsHelper(List<List<Integer>> ans, List<Integer> item, int n, int start) {
        if (n <= 1) {
            if (item.size() > 0) {
                ans.add(new ArrayList<Integer>(item));
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0 && i < n || (n == i && item.size() > 0)) {
                item.add(i);
                getFactorsHelper(ans, item, n/i, i);
                item.remove(item.size()-1);
            }
        }
        return;
    }
}
