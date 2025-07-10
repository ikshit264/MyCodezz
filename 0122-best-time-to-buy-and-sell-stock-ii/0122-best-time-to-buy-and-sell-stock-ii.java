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
        int[][] store = new int[prices.length][2];
        for (int[] row : store) Arrays.fill(row, -1);
        return solve(prices, 1, 0, store);
    }
}