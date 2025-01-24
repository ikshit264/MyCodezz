class Solution {
public:
    int countPaths(int i, int j, int m, int n, vector<vector<int>>& store) {
        if (i == n - 1 && j == m - 1) return 1; // Reached destination
        if (i >= n || j >= m) return 0;        // Out of bounds

        if (store[i][j] != -1) return store[i][j];

        store[i][j] = countPaths(i + 1, j, m, n, store) + countPaths(i, j + 1, m, n, store);
        return store[i][j];
    }

    int uniquePaths(int m, int n) {
        vector<vector<int>> store(n, vector<int>(m, -1)); // Dimensions are n x m
        return countPaths(0, 0, m, n, store);
    }
};
