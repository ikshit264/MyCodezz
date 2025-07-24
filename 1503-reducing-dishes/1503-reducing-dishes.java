import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction); // Sort ascending
        int n = satisfaction.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0, time = 1;
            for (int j = i; j < n; j++) {
                sum += time * satisfaction[j];
                time++;
            }
            result = Math.max(result, sum);
        }

        return result;
    }
}
