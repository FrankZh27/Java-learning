class Solution {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        int middle;
        while(left <= right) {
            middle = (left+right)/2;
            if (x/middle < middle) {
                right = middle-1;
            }
            else {
                left = middle+1;
            }
        }
        return left-1;
    }
}
