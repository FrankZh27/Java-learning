class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length-3; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++){
                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int lo = j+1;
                int hi = nums.length-1;
                while (lo < hi){
                    if (lo > j+1 && hi < nums.length-1 
                      && nums[lo] == nums[lo-1] && nums[hi] == nums[hi+1]){
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum == target){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while(nums[lo] == nums[lo+1] && lo < nums.length-2) lo++; 
                        while(nums[hi] == nums[hi-1] && hi > j+2) hi--;
                        lo++; hi--;
                        
                    }
                    else if(sum < target){
                        while(nums[lo] == nums[lo+1] && lo < nums.length-2) lo++;
                        lo++;
                    }
                    else{
                        while(nums[hi] == nums[hi-1] && hi > j+2) hi--;
                        hi--;
                    }
                }
            }
        }
        
        
        return ans;
    }
}
