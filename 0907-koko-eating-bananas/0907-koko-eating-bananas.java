class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);  // Maximum pile size

        while (left < right) {
            int mid = left + (right - left) / 2;
            long totalTime = 0;

            for (int pile : piles) {
                totalTime += (pile + mid - 1) / mid;  // Equivalent to ceil(pile / mid)
            }

            if (totalTime <= h) {
                right = mid;  // Try to find smaller speed
            } else {
                left = mid + 1;  // Need a bigger speed
            }
        }

        return left;
    }

    private int getMax(int[] piles) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        return maxPile;
    }

}