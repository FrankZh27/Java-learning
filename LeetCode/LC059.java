class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        ans = generateHelper(ans, 1, 0, 0, n-1, 0, n-1);
        return ans;
    }
    
    private int[][] generateHelper(int[][] ans, int curr, int direction,
                                   int left, int right, int up, int down) {
        if (left > right || up > down) {
            return ans;
        }
        if (direction == 0) {
            for (int i = left; i <= right; i++) {
                ans[up][i] = curr++;
            }
            ans = generateHelper(ans, curr, 1, left, right, up+1, down);
        }
        else if (direction == 1) {
            for (int i = up; i <= down; i++) {
                ans[i][right] = curr++;
            }
            ans = generateHelper(ans, curr, 2, left, right-1, up, down);
        }
        else if (direction == 2) {
            for (int i = right; i >= left; i--) {
                ans[down][i] = curr++;
            }
            ans = generateHelper(ans, curr, 3, left, right, up, down-1);
        }
        else {
            for (int i = down; i >= up; i--) {
                ans[i][left] = curr++;
            }
            ans = generateHelper(ans, curr, 0, left+1, right, up, down);
        }
        return ans;
    }
}
