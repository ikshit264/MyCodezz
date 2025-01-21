class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> store;
        long ans = 1;
        store.push_back(1);
        for (int i = 1; i < rowIndex + 1; i++) {
            ans = (ans*(rowIndex + 1 - i))/i;
            store.push_back(ans);
        }
        return store;
    }
};