class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();

        vector<vector<int>> dp(n, vector<int>(m, 0));

        // First row stays as is
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = dp[i - 1][j];
                int leftDiag = j > 0 ? dp[i - 1][j - 1] : 1e9;
                int rightDiag = j < m - 1 ? dp[i - 1][j + 1] : 1e9;

                dp[i][j] = matrix[i][j] + min({up, leftDiag, rightDiag});
            }
        }

        // Take min of last row
        int ans = INT_MAX;
        for (int j = 0; j < m; j++) {
            ans = min(ans, dp[n - 1][j]);
        }

        return ans;
    }
};
