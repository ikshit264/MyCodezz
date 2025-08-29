class Solution {
    int m, n;
    int [][][] store;

    private final int MOD = 1_000_000_007;
    public int solve(int moves, int row, int col){
        if ((row >= m || row < 0) || (col >= n || col < 0)){
            return 1;
        }
        if (moves == 0){
            return 0;
        }

        if (store[moves][row][col] != -1) return store[moves][row][col];

        return store[moves][row][col] = ((solve(moves-1, row+1, col) + solve(moves-1, row, col+1))%MOD + (solve(moves-1, row-1, col) + solve(moves-1, row, col-1))%MOD)%MOD;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        store = new int[maxMove+1][m][n];
        for(int[][] rows : store)
            for (int[] row : rows)
                Arrays.fill(row, -1);
        return solve(maxMove, startRow, startColumn);
    }
}