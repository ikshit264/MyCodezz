class Solution {
public:
    int func(vector<int>& nums, int k){
        if(k < 0) return 0;
        int l = 0, r = 0, count = 0, n = nums.size();
        unordered_map<int, int> store;
        while(r < n){
            store[nums[r]]++;
            while(store.size() > k){
                store[nums[l]]--;
                if (store[nums[l]]==0) store.erase(nums[l]);
                l++;
            }
            count += r-l+1;
            r++;
        }
        return count;
    }
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        return abs(func(nums, k) - func(nums, k-1));
    }
};