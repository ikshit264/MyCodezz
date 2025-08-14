public class Solution {
    int[] cuts;
    int[][] memo;

    public int minCost(int n, int[] cuts) {
        // Step 1: Sort and add boundaries
        Arrays.sort(cuts);
        this.cuts = new int[cuts.length + 2];
        this.cuts[0] = 0;
        this.cuts[this.cuts.length - 1] = n;
        for (int i = 0; i < cuts.length; i++) {
            this.cuts[i + 1] = cuts[i];
        }

        int m = this.cuts.length;
        memo = new int[m][m];
        for (int[] row : memo) Arrays.fill(row, -1);

        return dp(0, m - 1);
    }

    private int dp(int i, int j) {
        // No cut between i and j
        if (j - i <= 1) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int cost = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            cost = Math.min(cost, dp(i, k) + dp(k, j) + (cuts[j] - cuts[i]));
        }

        return memo[i][j] = cost;
    }
}
