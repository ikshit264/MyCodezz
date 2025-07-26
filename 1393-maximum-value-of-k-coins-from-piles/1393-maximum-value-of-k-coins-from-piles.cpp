class Solution {
public:
    int n;
    vector<vector<int>> dp;

    int solve(vector<vector<int>>& piles, int i, int k){
        if (i >= n) return 0;

        if (dp[i][k] != -1) return dp[i][k];

        int not_taken = solve(piles, i+1, k);

        int sum = 0, taken = 0;

        for (int j = 0; j < min(k, (int)piles[i].size()); j++){
            sum += piles[i][j];

            taken = max(taken, sum+ solve(piles, i+1, k-(j+1)));
        }

        return dp[i][k] = max(not_taken, taken);
    }
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        n = piles.size();
        dp.assign(n+1, vector<int>(k+1, -1));
        return solve(piles, 0, k);
    }
};