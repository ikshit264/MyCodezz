class Solution {
public:
    int func(vector<int>& nums, int k){
        if(k < 0)
            return 0;
        int l = 0, r = 0, odd_no = 0, count = 0, n = nums.size();
        while(r < n){
            if (nums[r]%2 == 1)
                odd_no += 1;
            while(odd_no > k){
                if (nums[l]%2 == 1)
                    odd_no -= 1;
                l++;
            }
            count += r-l+1;
            r++;
        }
        return count;
    }
    int numberOfSubarrays(vector<int>& nums, int k) {
        return abs(func(nums, k-1) - func(nums, k));
    }
};