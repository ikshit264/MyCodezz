class Solution {
    static int[] nums;
    int[] store;

    public int solve(int i){
        if (i >= nums.length) return 0;
        if (store[i] != -1) return store[i];

        int take = nums[i] + solve(i+2);
        int notTake = solve(i+1);

        return store[i] = Math.max(take, notTake);
    }

    public int rob(int[] nums) {
        this.nums = nums;
        store = new int[nums.length];
        java.util.Arrays.fill(store, -1);
        return solve(0);
    }
}