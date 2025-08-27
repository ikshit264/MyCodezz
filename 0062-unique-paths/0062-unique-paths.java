class Solution {
    int m;
    int n;
    int dp[][];

    // public int solve(int row, int col){
    //     if (row >= m || row < 0) return 0;
    //     if (col >= n || col < 0) return 0;
    //     if (row == m-1 && col == n-1) return 1;
    //     if (dp[row][col] != -1) return dp[row][col];

    //     return dp[row][col] = solve(row+1, col) + solve(row, col+1);
    // }

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        dp = new int[m][n];

        // if (m == 1 && n == 1) return 1;

        for (int[] row : dp){
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++){
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
