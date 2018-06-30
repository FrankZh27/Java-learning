class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<Integer>());
            ans.get(i).add(1);
            if (i == 0) {
                continue;
            }
            ans.get(i).add(1);
        }
        
        for (int i = 0; i < numRows; i++) {
            for (int j = 1; j < i; j++) {
                int num = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                ans.get(i).add(j, num);
            }
        }
        return ans;
    }
}
