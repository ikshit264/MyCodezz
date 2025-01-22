class Solution {
public:
    vector<vector<int>> highestPeak(vector<vector<int>>& mat) {
        int R = mat.size();
        int C = mat[0].size();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = 0;
                } else {
                    mat[i][j] = INT_MAX - 1;

                    if (i > 0)
                        mat[i][j] = min(mat[i][j], mat[i - 1][j] + 1);
                    if (j > 0)
                        mat[i][j] = min(mat[i][j], mat[i][j - 1] + 1);

                }
            }
        }

        for (int i = R - 1; i >= 0; i--) {
            for (int j = C - 1; j >= 0; j--) {
                if (i < R - 1)
                    mat[i][j] = min(mat[i][j], mat[i + 1][j] + 1);
                if (j < C - 1)
                    mat[i][j] = min(mat[i][j], mat[i][j + 1] + 1);
            }
        }

        return mat;
    }
};