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
        store = [-1] * n
        return self.solve(nums, store, n, 0)