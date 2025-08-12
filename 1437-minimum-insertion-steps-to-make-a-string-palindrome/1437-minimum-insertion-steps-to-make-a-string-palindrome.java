class Solution {
    static String s;
    int[][] store;

    public int solve(int i, int j){
        if (i >= j) return 0;
        if (store[i][j] != -1) return store[i][j];
        if (s.charAt(i) == s.charAt(j)) return solve(i + 1, j - 1);

        return store[i][j] = 1 + Math.min(solve(i+1, j), solve(i, j-1));
    }

    public int minInsertions(String s) {
        this.s = s;
        store = new int[s.length()][s.length()];

        for (int[] row : store) java.util.Arrays.fill(row, -1);
        return solve(0, s.length()-1);
    }
}