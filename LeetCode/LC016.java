class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0, j = 1, k = len - 1;
        int sum = nums[i] + nums[j] + nums[k];
        int currSum;
        
        outer: while(i < len-2){
            j = i+1; k = len-1;
            while(j < k){
                currSum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum-target) > Math.abs(currSum-target)){
                    sum = currSum;
                }
                
                if (currSum < target){
                    j++;
                }
                else if (currSum > target){
                    k--;
                }
                else{
                    break outer;
                }
            }
            i++;
        }
        return sum;
    }
}
