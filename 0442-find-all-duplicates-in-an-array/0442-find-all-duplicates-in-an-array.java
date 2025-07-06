class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> store = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1; 

            if (nums[idx] < 0){
                store.add(Math.abs(nums[i]));
            }
            nums[idx] *= -1;
        }

        return store;
    }
}