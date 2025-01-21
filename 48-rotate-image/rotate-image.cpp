class Solution {
public:
    vector<vector<int>> TransposeMat(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < m;
                 j++) { // Only swap elements above the diagonal
                swap(mat[i][j], mat[j][i]);
            }
        }
        return mat;
    }

    vector<vector<int>> ReverseCol(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size();

        for (int i = 0; i < n; i++) { // Reverse each row
            for (int j = 0; j < m / 2; j++) {
                swap(mat[j][i], mat[m - j - 1][i]);
            }
        }

        return mat;
    }
    void rotate(vector<vector<int>>& matrix) {
        ReverseCol(matrix);  // Step 2: Reverse each row
        TransposeMat(matrix); // Step 1: Transpose the matrix
    }
};