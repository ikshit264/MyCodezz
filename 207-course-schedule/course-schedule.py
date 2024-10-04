from collections import defaultdict

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = defaultdict(list)

        for a, b in prerequisites:
            adj[a].append(b)

        visited = [False] * numCourses
        def hasCycle(course):
            if visited[course] == 1:  # Cycle detected
                return True
            if visited[course] == 2:  # Already visited node
                return False
            
            visited[course] = 1  # Mark as visiting

            for neighbor in adj[course]:
                if hasCycle(neighbor):
                    return True
            
            visited[course] = 2  # Mark as visited
            return False
        
        for ngbr in range(numCourses):
            if hasCycle(ngbr):
                return False

        return 1