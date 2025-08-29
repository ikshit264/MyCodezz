class Solution {
    int m, n;
    List<String> board;
    int[][][] memo;
    final int MOD = 1_000_000_007;

    public int[] solve(int row, int col) {
        // If out of bounds or on an 'X'
        if (row >= m || col >= n || board.get(row).charAt(col) == 'X') {
            return new int[]{Integer.MIN_VALUE, 0}; // invalid path
        }

        // If reached 'S' (destination)
        if (board.get(row).charAt(col) == 'S') {
            return new int[]{0, 1}; // score 0, 1 path
        }

        if (memo[row][col][0] != -1) {
            return new int[]{memo[row][col][0], memo[row][col][1]};
        }

        // Explore next steps: down, right, diagonal
        int[] down = solve(row + 1, col);
        int[] right = solve(row, col + 1);
        int[] diag = solve(row + 1, col + 1);

        int maxScore = Math.max(down[0], Math.max(right[0], diag[0]));
        long ways = 0;

        if (down[0] == maxScore) ways += down[1];
        if (right[0] == maxScore) ways += right[1];
        if (diag[0] == maxScore) ways += diag[1];

        if (ways == 0) { // no valid path
            memo[row][col][0] = Integer.MIN_VALUE;
            memo[row][col][1] = 0;
            return new int[]{Integer.MIN_VALUE, 0};
        }

        int cellVal = (board.get(row).charAt(col) == 'E' ? 0 : board.get(row).charAt(col) - '0');
        int totalScore = (maxScore == Integer.MIN_VALUE ? Integer.MIN_VALUE : maxScore + cellVal);

        memo[row][col][0] = totalScore;
        memo[row][col][1] = (int)(ways % MOD);

        return new int[]{memo[row][col][0], memo[row][col][1]};
    }

    public int[] pathsWithMaxScore(List<String> board) {
        this.board = board;
        this.m = board.size();
        this.n = board.get(0).length();

        memo = new int[m][n][2];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(memo[i][j], -1);

        int[] res = solve(0, 0);

        if (res[1] == 0) return new int[]{0, 0}; // no path
        return new int[]{res[0], res[1]};
    }
}
