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

        // Manual implementation of lower_bound to find the index
        int left = 0, right = rows;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (lastColumn[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int row = left;

        if (row < rows && lastColumn[row] == target) return true;
        if (row >= rows) return false;

        // Binary search in the identified row
        return binary_search(matrix[row].begin(), matrix[row].end(), target);
    }
};
