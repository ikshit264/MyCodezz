class Solution {
    static String s;
    static int[] store;

    public int solve(int i){
        if (i >= s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (store[i] != -1) return store[i];

        long num = 0, ans = 0;

        for (int end = i; end < s.length(); end++){
            num = (num*10) + (s.charAt(end) - '0');
            if (num > 26 || num < 1) break;
            ans = ans + solve(end+1);
        }

        return store[i] = (int) ans;
    }

    public int numDecodings(String s) {
        this.s = s;
        this.store = new int[s.length()];

        java.util.Arrays.fill(store, -1);

        return solve(0);
    }
}
