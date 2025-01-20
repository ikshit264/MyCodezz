class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        m = len(mat)
        n = len(mat[0])
        store = {
            mat[row][col]: (row, col)
            for row in range(m)
            for col in range(n)
        }
        rows_count = [0] * m
        cols_count = [0] * n

        for i in range(len(arr)):
            num = arr[i]
            row, col = store[num]

            rows_count[row] += 1
            cols_count[col] += 1

            if rows_count[row] == n or cols_count[col] == m:
                return i

        return -1
