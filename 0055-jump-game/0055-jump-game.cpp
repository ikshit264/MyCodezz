class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();

        if (nums[0] == 0 && n > 1) return false;

        vector<int> countZero = {};
        for (int i = 1; i < n - 1; i++) {  // Skip first and last positions
            if (nums[i] == 0)
                countZero.push_back(i);
        }

        for (int i = 0; i < countZero.size(); i++) {
            bool isTrue = false;
            for (int j = countZero[i] - 1; j >= 0; j--) {
                if (nums[j] > countZero[i] - j) {
                    isTrue = true;
                    break;
                }
            }
            if (!isTrue) return false;
        }

        return true;
    }
};
