class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        store = {}
        for e in edges:
            for i in e:
                if i in store:
                    store[i] += 1
                else:
                    store[i] = 1
        for key, value in store.items():
            if store[key] == len(edges):
                return key

        return -1