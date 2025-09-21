class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> store = new HashSet<>();

        for( int num : nums){
            if (store.contains(num)) return num;
            store.add(num);
        }

        return -1;
    }
}