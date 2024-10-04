from collections import defaultdict

class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        # Build the graph as a directed adjacency list
        graph = defaultdict(list)
        for a, b in prerequisites:
            graph[b].append(a)

        # Track the state of each node: 0 = unvisited, 1 = visiting, 2 = visited
        visited = [0] * numCourses
        result = []
        cycle = [False]  # Use a list to maintain reference in the nested function

        # Helper function to perform DFS
        def dfs(course):
            if visited[course] == 1:  # Cycle detected
                cycle[0] = True
                return
            if visited[course] == 2:  # Already visited
                return

            # Mark as visiting
            visited[course] = 1
            for neighbor in graph[course]:
                dfs(neighbor)
                if cycle[0]:
                    return

            # Mark as visited
            visited[course] = 2
            result.append(course)

        # Call DFS for each course
        for course in range(numCourses):
            if visited[course] == 0:
                dfs(course)
            if cycle[0]:
                return []  # If a cycle is detected, return an empty list

        # Reverse the result to get the correct order
        return result[::-1]
