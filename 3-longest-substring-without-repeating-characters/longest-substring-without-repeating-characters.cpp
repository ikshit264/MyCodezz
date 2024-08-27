class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<int> store(255, -1);
        int l = 0, r = 0, maxlen = 0, n = s.length();
        while (r < n){
            if (store[s[r]] != -1){
                if (store[s[r]] >= l){
                    l = store[s[r]]+1;
                }
            }
            maxlen = max(maxlen, r-l+1);
            store[s[r]] = r;
            r++;
        }
        return maxlen;
    }
};