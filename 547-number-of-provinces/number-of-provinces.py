from typing import List

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        def dfs(city):
            stack = [city]
            while stack:
                current = stack.pop()
                for neighbor in range(len(isConnected)):
                    if isConnected[current][neighbor] == 1 and not visited[neighbor]:
                        visited[neighbor] = True
                        stack.append(neighbor)

        count = 0
        n = len(isConnected)
        visited = [False] * n

        # Loop through each city to find separate provinces
        for i in range(n):
            if not visited[i]:
                count += 1
                visited[i] = True
                dfs(i)

        return count
