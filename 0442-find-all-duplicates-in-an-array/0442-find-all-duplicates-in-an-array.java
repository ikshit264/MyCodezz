class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> store = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();

        for (int num : nums){
            if (!hs.add(num)) store.add(num);
        }

        return store;

    }
}