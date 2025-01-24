class Solution {
public:
    // int countPaths(int i, int j, int m, int n, vector<vector<int>>& store) {
    //     if (i == n - 1 && j == m - 1) return 1; // Reached destination
    //     if (i >= n || j >= m) return 0;        // Out of bounds

    //     if (store[i][j] != -1) return store[i][j];

    //     store[i][j] = countPaths(i + 1, j, m, n, store) + countPaths(i, j +
    //     1, m, n, store); return store[i][j];
    // }

    int nCr(int n, int r) {
        if (r > n - r)
            r = n - r; // Use the smaller of r or (n - r)
        long long store = 1;
        for (int i = 0; i < r; i++) {
            store *= (n - i);
            store /= (i + 1);
        }
        return (int)store;
    }

    int uniquePaths(int m, int n) { return nCr(m + n - 2, n - 1); }
};
