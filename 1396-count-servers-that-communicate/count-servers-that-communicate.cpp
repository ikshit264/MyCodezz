class Solution {
public:
    int countServers(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        vector<vector<bool>> visited(m, vector<bool>(n, false));
        int totalCount = 0;

        // Directions for traversing rows and columns
        vector<int> rowDir = {0, 0, 1, -1};
        vector<int> colDir = {1, -1, 0, 0};

        // BFS function
        auto bfs = [&](int startRow, int startCol) {
            queue<pair<int, int>> q;
            q.push({startRow, startCol});
            visited[startRow][startCol] = true;

            int count = 0;
            vector<pair<int, int>> connectedServers;

            while (!q.empty()) {
                auto [row, col] = q.front();
                q.pop();
                count++;
                connectedServers.push_back({row, col});

                // Traverse the row
                for (int i = 0; i < n; i++) {
                    if (i != col && grid[row][i] == 1 && !visited[row][i]) {
                        visited[row][i] = true;
                        q.push({row, i});
                    }
                }

                // Traverse the column
                for (int i = 0; i < m; i++) {
                    if (i != row && grid[i][col] == 1 && !visited[i][col]) {
                        visited[i][col] = true;
                        q.push({i, col});
                    }
                }
            }

            return count > 1
                       ? count
                       : 0; // Count servers only if communication is possible
        };

        // Main loop to find servers and perform BFS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    totalCount += bfs(i, j);
                }
            }
        }

        return totalCount;
    }
};