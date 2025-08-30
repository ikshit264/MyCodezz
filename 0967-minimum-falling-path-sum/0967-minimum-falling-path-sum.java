class Solution {
    int[][] matrix;
    int n;
    Integer[][] memo;               // null => uncomputed
    static final int INF = 1_000_000_000;

    int solve(int r, int c){
        if (c < 0 || c >= n || r >= n) return INF;   // invalid path
        if (r == n - 1) return matrix[r][c];

        if (memo[r][c] != null) return memo[r][c];

        int down = solve(r + 1, c);
        int dr   = solve(r + 1, c + 1);
        int dl   = solve(r + 1, c - 1);

        int best = Math.min(down, Math.min(dr, dl));
        return memo[r][c] = matrix[r][c] + best;     // best is large but safe (no overflow)
    }

    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        this.n = matrix.length;
        this.memo = new Integer[n][n];

        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < n; c++) {
            ans = Math.min(ans, solve(0, c));
        }
        return ans;
    }
}
