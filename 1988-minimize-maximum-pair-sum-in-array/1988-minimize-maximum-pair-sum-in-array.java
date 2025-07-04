import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxVal = 0;
        for (int i = 0; i < n/2; i++){
            maxVal = Math.max(maxVal, nums[i] + nums[n-i-1]);
        }
        return maxVal;
    }
}