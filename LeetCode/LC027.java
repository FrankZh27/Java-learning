class Solution {
    public int removeElement(int[] nums, int val) {
        
        if (nums.length == 0) return 0;
        if (nums.length == 1) {
            if (nums[0] == val) return 0;
            else return 1;
        };

        
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo <= hi) {
            while(lo <= hi && nums[lo] != val){
                lo++;
            }
            
            if (lo > hi) return hi+1;
            else if (lo == hi) return hi;
            
            while(lo <= hi && nums[hi] == val) hi--;
            
            if (lo > hi) return hi+1;
            
            nums[lo] = nums[hi];
            lo++;
            hi--;
        }
        return lo;
    }
}
