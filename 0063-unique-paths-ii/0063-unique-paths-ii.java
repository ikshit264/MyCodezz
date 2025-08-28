class Solution {
    public int uniquePathsWithObstacles(int[][] Grid) {
        int n = Grid.length;
        int m = Grid[0].length;

        int[] store = new int[m];

        // Initialize first row
        for (int i = 0; i < m; i++) {
            if (Grid[0][i] == 1) break;
            store[i] = 1;
        }

        // Process rest of the grid
        for (int i = 1; i < n; i++) {
            int[] temp = new int[m];

            if (Grid[i][0] == 0) temp[0] = store[0];

            for (int j = 1; j < m; j++) {
                if (Grid[i][j] == 0) {
                    temp[j] = store[j] + temp[j-1];
                }
            }

            store = temp;
        }

        return store[m-1];
    }
}
