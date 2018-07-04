class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                sum += (leftMax - height[left]);
                left++;
            }
            else {
                rightMax = Math.max(height[right], rightMax);
                sum += (rightMax - height[right]);
                right--;
            }
        }
        return sum;
    }
}
