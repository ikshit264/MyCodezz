class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        for (int i = 0; i < nums.size(); i++){
            int store = abs(nums[i]);
            if (nums[store-1] < 0) return store;
            nums[store-1] = -nums[store-1];
        } 
        return -1;
    }
};