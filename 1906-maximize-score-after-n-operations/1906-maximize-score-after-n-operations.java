import java.util.*;

class Solution {
    int[][] gcdGrid;
    int n;
    int[] nums;
    Map<Integer, Integer> memo = new HashMap<>();

    public int maxScore(int[] nums) {
        this.nums = nums;
        n = nums.length;

        // Precompute GCD values
        gcdGrid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gcdGrid[i][j] = gcd(nums[i], nums[j]);
            }
        }

        return solve(0, 1); // mask = 0 (none used), op = 1
    }

    int solve(int mask, int op) {
        if (mask == (1 << n) - 1) return 0; // all used

        if (memo.containsKey(mask)) return memo.get(mask);

        int best = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) continue;
            for (int j = i + 1; j < n; j++) {
                if ((mask & (1 << j)) != 0) continue;

                int newMask = mask | (1 << i) | (1 << j);
                int score = op * gcdGrid[i][j] + solve(newMask, op + 1);
                best = Math.max(best, score);
            }
        }

        memo.put(mask, best);
        return best;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
