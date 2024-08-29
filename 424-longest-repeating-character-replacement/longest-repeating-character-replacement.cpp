class Solution {
public:
    int characterReplacement(string s, int k) {
        int l = 0, r = 0, maxlen = 0, n = s.length(), maxfreq = 0;
        vector<int> store(26, 0);

        while(r < n){
            store[s[r] - 'A']++;
            maxfreq = max(maxfreq, store[s[r] - 'A']);
            while((r-l+1)-maxfreq > k){
                store[s[l] - 'A']--;
                l++;
            }
            maxlen = max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }
};