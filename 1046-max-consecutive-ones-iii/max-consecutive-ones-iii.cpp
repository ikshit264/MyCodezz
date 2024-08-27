class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
     int l = 0, r = 0, zeroes = 0;
     int n = nums.size();
     int maxlen = 0;
     while (r < n){
        if (nums[r] == 0){
            zeroes++;
            if (zeroes > k){
                while(nums[l] == 1)
                    l++;
                l++;
            }
        }
        maxlen = max(maxlen, r-l+1);
        r++;
     }
     return maxlen;
    }
};