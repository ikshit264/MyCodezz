class Solution:
    def solve(self, nums):
        n = len(nums)
        store = [-1] * (n+1)

        store[n] = 0
        store[n-1] = nums[n-1]

        for i in range(n-2, -1, -1):
            store[i] = max(nums[i] + store[i+2], store[i+1])
        
        return store[0]

    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 1:
            return sum(nums)
        store = [-1] * n
        return max( self.solve(nums[ : -1]), self.solve(nums[1 : ]))