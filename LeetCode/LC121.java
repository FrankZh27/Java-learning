class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int min = prices[0];
        int profit = prices[1]-min;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return profit > 0? profit : 0;
    }
}
