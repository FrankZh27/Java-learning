class Solution {
    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length-1;
        int currMax = 0;
        while(lo < hi){
            if (height[lo] < height[hi]){
                int area = height[lo] * (hi - lo);
                currMax = Math.max(currMax, area);
                lo++;
            }
            else if (height[lo] > height[hi]){
                int area = height[hi] * (hi - lo);
                currMax = Math.max(currMax, area);
                hi--;
            }
            else{
                int area = height[hi] * (hi - lo);
                currMax = Math.max(currMax, area);
                lo++; hi--;
            }
        }
        
        return currMax;
    }
}
