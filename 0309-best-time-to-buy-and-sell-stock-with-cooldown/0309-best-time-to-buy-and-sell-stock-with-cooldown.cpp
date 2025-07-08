class Solution {
public:
    int store[5001][2];
    int solve(vector<int>& prices, int i, int n, bool buy){
        if (i >= n){return 0;}

        if (store[i][buy] != -1) return store[i][buy];

        int profit = 0;

        if (buy){
            // sell
                int Sell = solve(prices, i+1, n, false) - prices[i];
            // skip
                int skip = solve(prices, i+1, n, true);
                
                profit = max(Sell, skip);
        } else {
            // buy
                int Buy = prices[i] + solve(prices, i+2, n, true);
            // Not buy
                int NotBuy = solve(prices, i+1, n, false);

                profit = max(Buy, NotBuy);
        }
        return store[i][buy] = profit;
    }
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        memset(store, -1, sizeof(store));
        return solve(prices, 0, n, true);
    }
};