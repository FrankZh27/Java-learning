class Solution {
    public void nextPermutation(int[] nums) {
        boolean isPossible = false;
        for (int i = 0; i <  nums.length-1; i++){
            if (nums[i] < nums[i+1]){
                isPossible = true;
                break;
            }
        }
        
        if (isPossible) {
            int i = nums.length-1;
            while(nums[i] <= nums[i-1]) i--;
            int temp = nums[i-1];
            int j = nums.length-1;
            while(nums[j] <= temp) j--;
            nums[i-1] = nums[j];
            nums[j] = temp;
            Arrays.sort(nums, i, nums.length); //This is tricky
            return;
        }
        else {
            Arrays.sort(nums);
            return;
        }
    }
}
