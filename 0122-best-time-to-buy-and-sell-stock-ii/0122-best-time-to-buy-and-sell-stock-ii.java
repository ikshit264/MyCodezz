class Solution {
    public int solve(int[] prices, int canBuy, int idx, int[][] store){
        if (idx == prices.length) return 0;
        if(store[idx][canBuy] != -1) return store[idx][canBuy];

        if (canBuy == 1) {
            int buy  = solve(prices, 0, idx+1, store) - prices[idx];
            int skip = solve(prices, 1, idx+1, store);
            return store[idx][canBuy] = Math.max(buy, skip);
        } else {
            int sell = solve(prices, 1, idx+1, store) + prices[idx];
            int skip = solve(prices, 0, idx+1, store);
            return store[idx][canBuy] = Math.max(sell, skip);
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            // Buy state
            dp[i][1] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);

            // Sell state
            dp[i][0] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
        }

        return dp[0][1];
    }
}