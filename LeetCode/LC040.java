class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        findCombinationSum2(ans, new ArrayList<Integer>(), candidates, target, 0, 0);
        return ans;
    }
    
    private void findCombinationSum2(List<List<Integer>> ans, List<Integer> combo,
                               int[] candidates, int target, int start, int sum) {
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i-1]) {
                continue;
            }
            combo.add(candidates[i]);
            sum += candidates[i];
            if (sum == target) {
                ans.add(new ArrayList<Integer>(combo));
            }
            else if (sum < target){
                findCombinationSum2(ans, combo, candidates, target, i+1, sum);
            }
            combo.remove(combo.size()-1);
            sum -= candidates[i];
        }
        return;  
    }
}
