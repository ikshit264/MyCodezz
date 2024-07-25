from typing import List

class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        if k == 1:
            return 0  
            
        nums.sort()
        n = len(nums)
        minimum_diff = float('inf')
        
        for i in range(n - k + 1):
            temp = nums[i + k - 1] - nums[i]
            if temp < minimum_diff:
                minimum_diff = temp
        
        return minimum_diff
