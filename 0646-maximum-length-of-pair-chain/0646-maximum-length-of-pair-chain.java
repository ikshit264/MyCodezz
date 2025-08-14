class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int n = pairs.length;
        int[] store = new int[n];

        java.util.Arrays.fill(store, 1);

        int result = 1;

        for (int i=0; i < n; i++){
            for (int j = 0; j < i; j++){
                if (pairs[i][0] > pairs[j][1]){
                    store[i] = Math.max(store[i], 1+store[j]);
                }
            }
            result = Math.max(store[i], result);
        }

        return result;
    }
}