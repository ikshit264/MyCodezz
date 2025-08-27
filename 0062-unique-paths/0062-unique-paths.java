class Solution {
    int m;
    int n;
    int dp[][];

    public int solve(int row, int col){
        if (row >= m || row < 0) return 0;
        if (col >= n || col < 0) return 0;
        if (row == m-1 && col == n-1) return 1;
        if (dp[row][col] != -1) return dp[row][col];

        return dp[row][col] = solve(row+1, col) + solve(row, col+1);
    }

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        dp = new int[m][n];

        for (int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(0, 0);
    }
}
