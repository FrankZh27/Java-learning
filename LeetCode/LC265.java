/*
Start from left to right, dp[i][j] record the minCost on the left
if ith house paint with color j.

Time complexity should be O(nkk)
*/
class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[costs.length][costs[0].length];
        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < costs.length; i++) {
            for (int j = 0; j < costs[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < costs[0].length; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[0].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < costs[0].length; k++) {
                    if (k == j) {
                        continue;
                    }
                    dp[i][j] = dp[i-1][k] + costs[i][j] < dp[i][j]?
                                dp[i-1][k]+costs[i][j]:dp[i][j];
                }
            }
        }
        for (int i = 0; i < costs[0].length; i++) {
            minCost = dp[costs.length-1][i] < minCost?
                        dp[costs.length-1][i]:minCost;
        }
        return minCost;
    }
}
