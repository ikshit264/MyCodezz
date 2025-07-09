class Solution
{
public:
    int solve (string &s, int n, int prevVal, int idx, vector<vector<int>>& store){
        if (idx >= n) return 0;

        if (store[idx][prevVal] != -1) return store[idx][prevVal];

        int flip = INT_MAX;
        int notFlip = INT_MAX;

        if (s[idx] == '0'){
            if (prevVal == 1){
                flip = 1 + solve(s, n, 1, idx+1, store);
            } else {
                flip = 1 + solve(s, n, 1, idx+1, store);
                notFlip = solve(s, n, 0, idx+1, store);
            }
        } else {
            if (prevVal == 1){
                notFlip = solve(s, n, 1, idx+1, store);
            } else {
                flip = 1 + solve(s, n, 0, idx+1, store);
                notFlip = solve(s, n, 1, idx+1, store);
            }
        }

        return store[idx][prevVal] = min(flip, notFlip);
    }
    int minFlipsMonoIncr(string S)
    {
        int n = S.size();
        vector<vector<int>> store(n, vector<int>(2, -1));
        return solve(S, n, 0, 0, store);
    }
};