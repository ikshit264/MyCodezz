class Solution {
    private int[] nums;
    private Long[][] store; // use Long for null-check memoization

    public long solve(int i, boolean isPositive) {
        if (i == nums.length) return 0;
        if (store[i][isPositive ? 1 : 0] != null) return store[i][isPositive ? 1 : 0];

        long notTake = solve(i + 1, isPositive);
        long take = (isPositive ? nums[i] : -nums[i]) + solve(i + 1, !isPositive);

        return store[i][isPositive ? 1 : 0] = Math.max(notTake, take);
    }

    public long maxAlternatingSum(int[] nums) {
        this.nums = nums;
        store = new Long[nums.length][2];
        return solve(0, true);
    }
}
