class Solution {
public:
    int numberOfSubstrings(string s) {
        int r = 0, l = 0, count = 0, n = s.length();
        std::vector<int> store(3, -1);
        while (r < n){
            store[s[r] - 'a'] = r;
            if (store[0] > -1 && store[1] > -1 && store[2] > -1){
                count += min(store[0],min(store[1],store[2])) + 1;
            }
            r++;
        }
        return count;
    }
};