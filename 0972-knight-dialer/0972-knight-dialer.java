class Solution {
    static final int MOD = 1_000_000_007;
    static final Map<Integer, List<Integer>> jumps = new HashMap<>();
    private long[][] store;
    static {
        jumps.put(0, Arrays.asList(4, 6));
        jumps.put(1, Arrays.asList(6, 8));
        jumps.put(2, Arrays.asList(7, 9));
        jumps.put(3, Arrays.asList(4, 8));
        jumps.put(4, Arrays.asList(3, 9, 0));
        jumps.put(5, Arrays.asList());
        jumps.put(6, Arrays.asList(1, 7, 0));
        jumps.put(7, Arrays.asList(2, 6));
        jumps.put(8, Arrays.asList(1, 3));
        jumps.put(9, Arrays.asList(2, 4));
    }

    public long solve(int n, int i){
        if (n == 0) return 1;
        if (store[n][i] != -1) return store[n][i];

        long ans = 0;

        for (int dig : jumps.get(i)) ans = (ans + solve(n-1, dig))%MOD;

        return store[n][i] = ans;
    }

    public int knightDialer(int n) {
        store = new long[n][10];

        long result = 0;

        for (long[] row : store) Arrays.fill(row, -1);

        for (int i = 0; i < 10; i++){
            result = (result + solve(n-1, i))%MOD;
        }

        return (int)result;
    }
}