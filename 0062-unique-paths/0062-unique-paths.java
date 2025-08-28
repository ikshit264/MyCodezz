class Solution {
    int m;
    int n;
    int dp[];

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
        dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++){
            int[] temp = new int[n];
            temp[0] = 1;
            for (int j = 1; j < n; j++){
                temp[j] = dp[j] + temp[j-1];
            }
            // for (int j : dp) System.out.print(j + " ");
            // System.out.println("");
            dp = temp;
        }

        return dp[n-1];
    }
}
