class Solution {
    // static String s;
    // int[][] store;

    // public int solve(int i, int j){
    //     if (i >= j) return 0;
    //     if (store[i][j] != -1) return store[i][j];
    //     if (s.charAt(i) == s.charAt(j)) return solve(i + 1, j - 1);

    //     return store[i][j] = 1 + Math.min(solve(i+1, j), solve(i, j-1));
    // }

    public int minInsertions(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lps = dp[n][n];
        return n - lps;
    }
}