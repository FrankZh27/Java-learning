class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        Arrays.sort(nums);
        int prev = nums[nums.length-1];
        int count = k;
        int idx = nums.length-2;
        
        while (idx >= 0 && count > 1) {
            count--;
            prev = nums[idx];
            idx--;
        }
        return prev;
    }
}
