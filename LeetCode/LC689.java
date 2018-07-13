class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[3];
        int[] left = new int[n];
        int[] right = new int[n];
        int[] middle = new int[n];
        
        int currMax = 0;
        int currSum = 0;
        
        // calculate left[]
        for (int i = 0; i < k; i++) {
            currMax += nums[i];
        }
        currSum = currMax;
        left[k-1] = 0;
        
        for (int i = k; i < n; i++) {
            currSum = currSum + nums[i] - nums[i-k];
            if (currSum > currMax) {
                currMax = currSum;
                left[i] = i-k+1;
            }
            else {
                left[i] = left[i-1];
            }
        }
        
        // calculate right[]
        currMax = 0;
        for (int i = n-1; i >= n-k; i--) {
            currMax += nums[i];
        }
        currSum = currMax;
        right[n-k] = n-k;
        
        for (int i = n-k-1; i >= 0; i--) {
            currSum = currSum + nums[i] - nums[i+k];
            if (currSum > currMax) {
                currMax = currSum;
                right[i] = i;
            }
            else {
                right[i] = right[i+1];
            }
        }
        
        // calculate middle[]
        currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }
        middle[0] = currSum;
        
        for (int i = 1; i <= n-k; i++) {
            currSum = currSum - nums[i-1] + nums[i+k-1];
            middle[i] = currSum;
        }
        
        currSum = 0;
        currMax = 0;
        
        for (int i = k; i <= n-k-k; i++) {
            currSum = middle[i] + middle[left[i-1]] + middle[right[i+k]];
            if (currSum > currMax) {
                currMax = currSum;
                ans[0] = left[i-1];
                ans[1] = i;
                ans[2] = right[i+k];
            }
        }
        return ans;
        
    }
}
