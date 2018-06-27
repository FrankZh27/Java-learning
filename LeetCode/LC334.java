class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int min = nums[0];
        int left = min;
        int middle = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > middle) {
                return true;
            }
            if (nums[i] < min) {
                min = nums[i];
            }
            else if (nums[i] > min && nums[i] < middle) {
                left = min;
                middle = nums[i];
            }
        }
        return false;
    }
}
