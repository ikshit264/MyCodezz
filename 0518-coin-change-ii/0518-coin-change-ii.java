class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] store = new int[n+1][amount+1];

        for (int i = 0; i < n; i++){
            store[i][0] = 1;
        }

        for (int  i = 1; i <= n; i++){
            for (int j = 0; j <= amount; j++){
                // Take
                if (j >= coins[i-1]){
                    store[i][j] = store[i-1][j] + store[i][j - coins[i-1]];
                }else{
                    store[i][j] = store[i-1][j];
                }
            }
        }
        return store[n][amount];
    }
}