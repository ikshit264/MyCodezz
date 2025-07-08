class Solution {
public:
    int solve(int n, vector<int>& store){
        if (store[n] != -1) return store[n];

        return store[n] = solve(n-1, store) + solve(n-2, store);
    }
    int climbStairs(int n) {
        if (n==1) return 1;
        vector<int> store(n, -1);
        store[0] = 1;
        store[1] = 2;
        return solve(n-1, store);
    }
};