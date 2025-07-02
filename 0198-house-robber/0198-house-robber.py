class Solution:
    def solve(self, nums, store, n, i):
        if i >= n:
            return 0

        if store[i] != -1 : return store[i]

        take = nums[i] + self.solve(nums, store, n, i+2)
        notTake = self.solve(nums, store, n, i+1)

        store[i] = max(take, notTake)

        return store[i]

    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        store = [-1] * (n+1)
        store[n] = 0
        store[n-1] = nums[n-1]
        for i in range(n-2, -1, -1):
            store[i] = max(store[i+1], store[i+2] + nums[i])
        return store[0]