class Solution {
    static String s;
    static int k;
    static int MOD = 1_000_000_007;
    static int[] store;

    public int solve(int i){
        if (i >= s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (store[i] != -1) return store[i];

        long ans = 0;
        long num = 0;

        for (int end = i; end < s.length(); end++){
            num = (num*10) + (s.charAt(end) - '0');
            if (num > k) break;
            ans = (ans%MOD + solve(end+1)%MOD)%MOD;
        }

        return store[i] = (int) ans;
    }

    public int numberOfArrays(String s, int k) {
        this.s = s;
        this.k = k;
        this.store = new int[s.length()];

        java.util.Arrays.fill(store, -1);

        return solve(0);
    }
}