from typing import List
from collections import Counter

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        count = Counter(nums)
        unique_nums = sorted(count.keys())
        n = len(unique_nums)

        dp = [0] * (n + 2)  # padding for i + 2

        for i in range(n - 1, -1, -1):
            take = unique_nums[i] * count[unique_nums[i]]
            if i + 1 < n and unique_nums[i + 1] == unique_nums[i] + 1:
                take += dp[i + 2]
            else:
                take += dp[i + 1]

            dp[i] = max(take, dp[i + 1])

        return dp[0]
