class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        if (matrix.empty()) return 0;
        int n = matrix.size();
        int m = matrix[0].size();

        vector<vector<long long>> store(n, vector<long long>(m, 0));

        // First row stays the same
        for (int j = 0; j < m; j++) {
            store[0][j] = matrix[0][j];
        }

        // Bottom-up DP
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long long up = store[i - 1][j];
                long long leftDiag = (j > 0) ? store[i - 1][j - 1] : 1e9;
                long long rightDiag = (j < m - 1) ? store[i - 1][j + 1] : 1e9;

                store[i][j] = matrix[i][j] + min({up, leftDiag, rightDiag});
            }
        }

        // Final answer: minimum value in the last row
        long long mini = LLONG_MAX;
        for (int j = 0; j < m; j++) {
            mini = min(mini, store[n - 1][j]);
        }

        return (int)mini;
    }
};
