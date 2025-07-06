class Solution {
public:
    // Check if s1 has duplicate chars, or s1 shares chars with s2
    bool hasDuplicate(string &s1, string &s2) {
        int arr[26] = {0};

        // Check for duplicate in s1 itself
        for (auto &ch : s1) {
            if (arr[ch - 'a'] != 0) return true;
            arr[ch - 'a']++;
        }

        // Check if s2 shares chars with s1
        for (auto &ch : s2) {
            if (arr[ch - 'a'] != 0) return true;
        }

        return false;
    }

    int solve(vector<string>& strs, int n, int i, string temp) {
        if (i >= n) return temp.length();

        int take = 0, notTake = 0;

        if (!hasDuplicate(strs[i], temp)) {
            take = solve(strs, n, i + 1, temp + strs[i]);
        }
        notTake = solve(strs, n, i + 1, temp);

        return max(take, notTake);
    }

    int maxLength(vector<string>& arr) {
        return solve(arr, arr.size(), 0, "");
    }
};
