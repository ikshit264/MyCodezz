from collections import defaultdict

class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        visited = [False] * n
        adj = defaultdict(list)
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        edges = adj
        stack = []

        stack.append(source)

        while stack:
            curr = stack.pop(-1)

            if curr == destination:
                return True 
            if not visited[curr] :
                # store.append(curr)
                visited[curr] = True

                for ngbr in edges[curr]:
                    if not visited[ngbr]:
                        stack.append(ngbr)
                        
        return False
