class Solution {
    public int solve(int[] jD, int n, int j, int d, int[][] store){
        if (n - j < d) return Integer.MAX_VALUE;

        if (d == 1){
            int maxVal = Integer.MIN_VALUE;
            for(int i = j; i < n; i++){
                maxVal = Math.max(jD[i], maxVal);
            }
            return maxVal;
        }

        if (store[j][d] != -1) return store[j][d]; 

        int maxVal = jD[j];
        int finalResult = Integer.MAX_VALUE;

        for (int i = j; i < n; i++){
            maxVal = Math.max(maxVal, jD[i]);

            int result = solve(jD, n, i + 1, d - 1, store);
            if (result != Integer.MAX_VALUE) {
                finalResult = Math.min(finalResult, maxVal + result);
            }
        }

        return store[j][d] = finalResult;
    }
    public int minDifficulty(int[] jD, int d) {

        int n = jD.length;
        if (n < d) return -1;
        int[][] store = new int[n+1][d+1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(store[i], -1);
        }

        int result = solve(jD, n, 0, d, store);

        return result;
    }
}