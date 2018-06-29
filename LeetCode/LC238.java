class Solution {
    public int[] productExceptSelf(int[] nums) {
       
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        
        int[] leftMul = new int[n];
        int[] rightMul = new int[n];
        int[] ans = new int[n];
        
        leftMul[0] = 1;
        rightMul[n-1] = 1;
        
        for (int i = 1; i < n; i++) {
            leftMul[i] = leftMul[i-1] * nums[i-1];
            rightMul[n-i-1] = rightMul[n-i] * nums[n-i];
        }
        
        for (int i = 0; i < n; i++) {
            ans[i] = leftMul[i] * rightMul[i];
        }
        return ans;
    }
}
