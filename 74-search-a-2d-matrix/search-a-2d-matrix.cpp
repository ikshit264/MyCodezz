class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rows = matrix.size();
        if (rows == 0) return false;
        int cols = matrix[0].size();
        if (cols == 0) return false;

        vector<int> lastColumn(rows);
        for (int i = 0; i < rows; i++) {
            lastColumn[i] = matrix[i][cols - 1];
        }

        auto it = lower_bound(lastColumn.begin(), lastColumn.end(), target);
        int row = it - lastColumn.begin();

        if (row < rows && lastColumn[row] == target) return true;
        if (row >= rows) return false;
        return binary_search(matrix[row].begin(), matrix[row].end(), target);
    }
};
