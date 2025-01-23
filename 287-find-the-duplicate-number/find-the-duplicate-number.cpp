class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        for (int i = 0; i < nums.size(); i++){
            int store = abs(nums[i]);
            if (nums[store] < 0) return store;
            nums[store] = -nums[store];
        }
        return -1;
    }
};