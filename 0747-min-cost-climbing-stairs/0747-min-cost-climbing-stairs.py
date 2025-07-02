class Solution:
    def Cost(self, cost, i, store, n):
        if i >= n : 
            return 0
        if store[i] != -1 : 
            return store[i]
        
        take1 = cost[i] + self.Cost(cost, i+1, store, n)
        take2 = cost[i] + self.Cost(cost, i+2, store, n)

        store[i] =  min(take1, take2)

        return store[i]

    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        store = [-1] * (n+1)
        store[n] = 0
        store[n-1] = cost[n-1]
        for i in range(n-2, -1, -1):
            store[i] = cost[i] + min(store[i+1], store[i+2])
        print(store)
        return min(store[1], store[0])