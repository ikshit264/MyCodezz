class Solution {
    final int MAX_INT = 1_000_000_001;
    // int[] arr1, arr2;
    Map<String, Integer> store = new HashMap<>();

    private int upperBound(int[] arr, int target){
        int left = 0, right = arr.length;

        while(left < right){
            int mid = left+(right-left)/2;
            if (arr[mid] <= target) left = mid+1;
            else right = mid;
        }
        return left;
    }

    public int solve(int i, int[] arr1, int[] arr2, int prev){
        if (i >= arr1.length) return 0;

        String key = i + "," + prev;
        if (store.containsKey(key)) return store.get(key);
        
        int result1 = MAX_INT;

        if (arr1[i] > prev) {
            result1 = solve(i+1, arr1, arr2, arr1[i]);
        }

        int result2 = MAX_INT;

        int j = upperBound(arr2, prev);
        if (j < arr2.length)
            result2 = 1 + solve(i+1, arr1, arr2, arr2[j]);


        int ans = Math.min(result1, result2);
        store.put(key, ans);
        return ans;
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        // this.arr1=arr1;
        // this.arr2=arr2;
        Arrays.sort(arr2);
        int result = solve(0, arr1, arr2, Integer.MIN_VALUE);
        return result == MAX_INT ? -1 : result;
    }
}