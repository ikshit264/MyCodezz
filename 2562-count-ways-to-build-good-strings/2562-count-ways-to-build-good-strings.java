class Solution {
    static private int high, low, zero, one;
    int[] store;
    static int MOD = 1_000_000_007;

    public int solve(int i){
        if (i > high) return 0;
        if (store[i] != -1) return store[i];

        int count = 0;

        if (i >= low) count = (count+1)%MOD;

        count = (count + solve(i+one)%MOD)%MOD;
        count = (count + solve(i+zero)%MOD)%MOD;

        return store[i] = count;
    } 

    public int countGoodStrings(int low, int high, int zero, int one) {
        this.high = high;
        this.low = low;
        this.zero = zero;
        this.one = one;

        store = new int[high+1];
        java.util.Arrays.fill(store, -1);

        return solve(0);
    }
}