import java.util.*;

class Solution {

    // Check if sublist is strictly increasing
    public boolean isStrictlyIncreasing(List<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for (int i = 0; i <= n - 2 * k; i++) {
            List<Integer> first = nums.subList(i, i + k);
            List<Integer> second = nums.subList(i + k, i + 2 * k);

            if (isStrictlyIncreasing(first) && isStrictlyIncreasing(second)) {
                return true;
            }
        }

        return false;
    }
}
