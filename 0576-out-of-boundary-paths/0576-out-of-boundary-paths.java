class Solution {
    private final int MOD = 1_000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[maxMove + 1][m][n];

        for (int move = 1; move <= maxMove; move++) {
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    long ways = 0;

                    // down
                    if (r + 1 < m) ways += dp[move - 1][r + 1][c];
                    else ways += 1;

                    // up
                    if (r - 1 >= 0) ways += dp[move - 1][r - 1][c];
                    else ways += 1;

                    // right
                    if (c + 1 < n) ways += dp[move - 1][r][c + 1];
                    else ways += 1;

                    // left
                    if (c - 1 >= 0) ways += dp[move - 1][r][c - 1];
                    else ways += 1;

                    dp[move][r][c] = (int)(ways % MOD);
                }
            }
        }

        return dp[maxMove][startRow][startColumn];
    }
}
