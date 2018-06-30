class Solution {
    public int arrayNesting(int[] nums) {
        
        int n = nums.length;
        int[] ptrs = new int[nums.length];
        int count = 0;
        int currSum = 0;
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            ptrs[i] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            int idx = i;
            currSum = 0;
            while (ptrs[idx] == -1) {
                count++;
                currSum++;
                ptrs[idx] = nums[idx];
                idx = nums[idx];
            }
            max = currSum > max ? currSum:max;
            if (count == n) {
                return max;
            }
        }
        return max;
    }
}
