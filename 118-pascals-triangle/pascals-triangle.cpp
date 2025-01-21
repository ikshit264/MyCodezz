#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> generateRow(int row){
        long long ans = 1;
        vector<int> store;
        store.push_back(1);

        for (int i = 1; i < row; i++){
            ans *= (row - i);
            ans /= (i);
            store.push_back(ans);
        }
        return store;
    }


    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> store;
        for (int i = 1; i <= numRows; i++){
            store.push_back(generateRow(i));
        }
        return store;
    }
};