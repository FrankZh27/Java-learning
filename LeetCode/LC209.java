class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < nums.length) {
            while (right < nums.length && sum < s) {
                sum += nums[right++];
            }
            if (sum >= s && right-left < len) {
                len = right-left;
            }
            if (right < nums.length) {
                sum += nums[right++];
            }
            while (left < right && sum-nums[left] >= s) {
                sum -= nums[left++];
            }
        }
        if (sum >= s && right-left < len) {
            len = right - left;
        }
        if (len != Integer.MAX_VALUE) {
            return len;
        }
        return 0;
    }
}
