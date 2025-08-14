class Solution {
    static int[] nums;
    Integer[] store;

    // public int solve(int i, int prevIndex){
    //     if (i >= nums.length) return 0;
    //     if (store[i][prevIndex + 1] != null) return store[i][prevIndex + 1];

    //     int notTake = solve(i+1, prevIndex);
    //     int take = 0;

    //     if (prevIndex == -1 || nums[i] > nums[prevIndex]){
    //         take = 1 + solve(i+1,i);
    //     }

    //     return store[i][prevIndex + 1] = Math.max(notTake, take);
    // }
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        store = new Integer[n];
        java.util.Arrays.fill(store, 1);

        int result = 1;
        for (int i=0; i < n; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i])
                    store[i] = Math.max(store[i], 1 + store[j]);
            }
            result = Math.max(result, store[i]);
        }
        return result;
    }
}