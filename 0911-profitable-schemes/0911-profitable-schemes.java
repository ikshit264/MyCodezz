class Solution {

    static int minProfit, n;
    static int[] group, profits;
    static int[][][] store;

    public int solve(int noOfPpl, int j, int profit){
        if (j >= group.length) {
            return profit >= minProfit ? 1 : 0;
        }
        if (noOfPpl > n) return 0;
        if (store[noOfPpl][j][profit] != -1) return store[noOfPpl][j][profit];

        long ways = solve(noOfPpl, j+1, profit);

        if (group[j] + noOfPpl <= n){
            ways += solve(group[j] + noOfPpl, j+1, Math.min(minProfit, profit + profits[j]));
        }

        return store[noOfPpl][j][profit] = (int) (ways % 1_000_000_007);

    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profits) {
        this.n = n;
        this.minProfit = minProfit;
        this.group = group;
        this.profits = profits;
        this.store = new int[n+1][group.length+1][minProfit+1];

        for (int[][] arr2d : store) {
                    for (int[] arr1d : arr2d) {
                        java.util.Arrays.fill(arr1d, -1);
                    }
                }
        return solve(0, 0, 0);
    }
}