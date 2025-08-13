class Solution {
    int[] piles;
    int[][][] store;

    public int solve(boolean isAlice, int i, int M){
        if (i >= piles.length) return 0;
        if (store[isAlice ? 0 : 1][i][M] != -1) return store[isAlice ? 0 : 1][i][M];

        int stones = 0;
        int res = isAlice ? 0 : Integer.MAX_VALUE;

        for (int x = 1; x <= Math.min(piles.length - i, 2*M); x++){
            stones += piles[i+x-1];
            if (isAlice) {
                res = Math.max(res, stones + solve(false, i+x,  Math.max(M, x)));
            } else {
                res = Math.min(res, solve(true, i+x, Math.max(M, x)));
            }
        }

        return store[isAlice ? 0 : 1][i][M] = res;
    }

    public int stoneGameII(int[] piles) {
        this.piles = piles;
        store = new int[2][piles.length+1][piles.length+1];

        for (int[][] grid : store) for (int[] row : grid) java.util.Arrays.fill(row, -1);

        return solve(true, 0, 1);
    }
}