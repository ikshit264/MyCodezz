#include <unordered_map>

class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        int l = 0, r = 0, maxlen = 0, n = fruits.size(), k =2;
        unordered_map<int, int> store;
        while(r < n){
            store[fruits[r]]++;
            if (store.size() > k){
                while(store.size() > k){
                    store[fruits[l]]--;
                    if (store[fruits[l]] == 0){
                        store.erase(fruits[l]);
                    }
                    l++;
                }
            }
            maxlen = max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }
};