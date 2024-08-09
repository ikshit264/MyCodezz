class Solution:
    def checkIfMagicSquare(self, m: list[list[int]]) -> bool:
        elements = [m[i][j] for i in range(3) for j in range(3)]
        if (sorted(elements)) != list(range(1,10)):
            return False

        return (
            m[0][0] + m[0][1] + m[0][2] == m[1][0] + m[1][1] + m[1][2] == m[2][0] + m[2][1] + m[2][2] ==  
            m[0][0] + m[1][0] + m[2][0] == m[0][1] + m[1][1] + m[2][1] == m[0][2] + m[1][2] + m[2][2] ==  
            m[0][0] + m[1][1] + m[2][2] == m[0][2] + m[1][1] + m[2][0]
        )
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        count = 0
        for i in range(len(grid)-2):
            for j in range(len(grid[0])-2):
                subgrid = [row[j:j + 3] for row in grid[i:i + 3]]
                if self.checkIfMagicSquare(subgrid):
                    count+=1
        return count