class Solution {
    private int[] nums;

    public int solve(int i, int end, int[] store) {
        if (i > end) return 0; // inclusive range, so `> end` is base case
        if (store[i] != -1) return store[i];

        int take = nums[i] + solve(i + 2, end, store);
        int notTake = solve(i + 1, end, store);

        return store[i] = Math.max(take, notTake);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        this.nums = nums;

        // Case 1: Rob houses 0 to n-2
        int[] store1 = new int[n];
        java.util.Arrays.fill(store1, -1);
        int case1 = solve(0, n - 2, store1);

        // Case 2: Rob houses 1 to n-1
        java.util.Arrays.fill(store1, -1);
        int case2 = solve(1, n - 1, store1);

        return Math.max(case1, case2);
    }
}
