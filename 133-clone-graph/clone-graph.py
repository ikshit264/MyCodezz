# Definition for a Node.
class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

from typing import Optional
from collections import deque

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None

        # Use a dictionary to map original nodes to their clones
        clones = {node.val: Node(node.val, [])}
        q = deque([node])

        while q:
            cur = q.popleft()
            cur_clone = clones[cur.val]

            for ngbr in cur.neighbors:
                if ngbr.val not in clones:
                    # Create a clone of the neighbor node if not already cloned
                    clones[ngbr.val] = Node(ngbr.val, [])
                    q.append(ngbr)

                # Add the cloned neighbor to the current cloned node's neighbors
                cur_clone.neighbors.append(clones[ngbr.val])

        return clones[node.val]
