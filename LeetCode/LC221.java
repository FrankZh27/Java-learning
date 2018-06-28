class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        
        //Initialize dp matrix
        dp[0][0] = matrix[0][0] - '0';
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i-1] + (matrix[0][i]-'0');
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + (matrix[i][0]-'0');
        }
        
        // Calculate sum
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + (matrix[i][j]-'0');
            }
        }
        
        // Find the minimum 
        int max = 0;
        for (int i = 1; i < row; i++) {
            int k = 0;
            while(i+k < row && k < col) {
                int curr = dp[i+k][k]- dp[i-1][k];
                if (curr == (k+1)*(k+1)) {
                    max = curr > max ? curr:max;
                }
                k++;
            }
        }
        
        for (int i = 1; i < col; i++) {
            int k = 0;
            while(i+k < col && k < row) {
                int curr = dp[k][i+k] - dp[k][i-1];
                if (curr == (k+1)*(k+1)) {
                    max = curr > max ? curr:max;
                }
                k++;
            }
        }
        
        int idx = 0;
        while(idx < row && idx < col) {
            if (dp[idx][idx] == (idx+1)*(idx+1)) {
                max = dp[idx][idx] > max ? dp[idx][idx]:max;
            }
            idx++;
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int k = 0;
                while (i+k < row && j+k <col) {
                    int curr = dp[i+k][j+k] - dp[i-1][j+k] - dp[i+k][j-1] + dp[i-1][j-1];
                    if (curr == (k+1)*(k+1)) {
                        max = curr > max ? curr:max;
                    }
                    k++;
                }
            }
        }
        return max;
    }
}
