class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] list = nums.clone();
        Arrays.sort(list);
        int low = 0;
        int hi = nums.length-1;
        while(low < hi) {
            if (list[low] + list[hi] == target) break;
            if (list[low] + list[hi] > target) hi--;
            if (list[low] + list[hi] < target) low++;
        }
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == list[low]) {
                ans[0] = i;
                break;
            }
        }
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] == list[hi]) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}
