class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int nextMax = currMax * nums[i];
            int nextMin = currMin * nums[i];
            currMax = Math.max(Math.max(nextMax, nextMin), nums[i]);
            currMin = Math.min(Math.min(nextMax, nextMin), nums[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }
}
