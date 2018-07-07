class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        combinationSum3Helper(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }
    
    private void combinationSum3Helper(List<List<Integer>> ans, List<Integer> list,
                                       int k, int start, int n) {
        if (n < 0 || start > 9) {
            return;
        }
        if (list.size() == k-1) {
            if (n == 0) {
                return;
            }
            if (start <= n && n <= 9) {
                list.add(n);
                ans.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
                return;
            }
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            combinationSum3Helper(ans, list, k, i+1, n-i);
            list.remove(list.size()-1);
        }
        return;
    }
}
