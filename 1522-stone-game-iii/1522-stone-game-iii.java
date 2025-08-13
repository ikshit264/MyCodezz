class Solution {
    int[] stoneValue;
    Integer[] memo;

    public int solveAlice(int i) {
        if (i >= stoneValue.length) return 0;
        if (memo[i] != null) return memo[i];

        int result = Integer.MIN_VALUE;
        int total = 0;

        for (int x = 0; x < 3 && i + x < stoneValue.length; x++) {
            total += stoneValue[i + x];
            result = Math.max(result, total - solveAlice(i + x + 1));
        }

        return memo[i] = result;
    }

    public String stoneGameIII(int[] stoneValue) {
        this.stoneValue = stoneValue;
        memo = new Integer[stoneValue.length];

        int diff = solveAlice(0); // Alice's score difference over Bob

        if (diff > 0) return "Alice";
        if (diff < 0) return "Bob";
        return "Tie";
    }
}
