class Solution {

    static int[][] freq;
    static String[] words;
    static String target;
    static int[][] store;

    public int solve(int i, int j){
        if (target.length() <= i) return 1;
        if (words[0].length() <= j) return 0;

        if (store[i][j] != -1) return store[i][j];

        long ways = solve(i, j + 1);

        // Option 2: take this column if it has the needed char
        int charIndex = target.charAt(i) - 'a';
        if (freq[charIndex][j] > 0) {
            ways += (long) freq[charIndex][j] * solve(i + 1, j + 1);
        }

        return store[i][j] = (int) (ways % 1_000_000_007);
    }

    public int numWays(String[] words, String target) {
        this.words = words;
        this.target = target;
        int length = words[0].length();
        freq = new int[26][length];

        for (String str : words){
            for (int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                int row = c - 'a';
                freq[row][i]++;
            }
        }

        this.store = new int[target.length()][length];
        for (int[] row : store) java.util.Arrays.fill(row, -1);

        return solve(0, 0);
    }
}