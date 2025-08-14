import java.util.*;

class Solution {
    int[][] pairs;
    int[] dp; // memo

    private int binarySearch(int idx, int n) {
        int left = 0, right = n;
        int target = pairs[idx][1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (pairs[mid][0] > target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left; // may return n (out of bounds if no valid next pair)
    }

    private int solve(int idx) {
        if (idx >= pairs.length) return 0;
        if (dp[idx] != -1) return dp[idx];

        // Skip current pair
        int skip = solve(idx + 1);

        // Take current pair
        int nextIdx = binarySearch(idx, pairs.length);
        int take = 1 + solve(nextIdx);

        return dp[idx] = Math.max(skip, take);
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        this.pairs = pairs;
        dp = new int[pairs.length];
        Arrays.fill(dp, -1);

        return solve(0);
    }
}
