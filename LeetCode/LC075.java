class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                red++;
            }
            if (nums[i] == 1) {
                white++;
            }
            if (nums[i] == 2) {
                blue++;
            }
        }
        int index = 0;
        while(red != 0) {
            nums[index++] = 0;
            red--;
        }
        while(white != 0) {
            nums[index++] = 1;
            white--;
        }
        while(blue != 0) {
            nums[index++] = 2;
            blue--;
        }
        return;
    }
}
