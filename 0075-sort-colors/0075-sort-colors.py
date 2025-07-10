class Solution:
    def sortColors(self, nums: List[int]) -> None:
        n = len(nums)
        pos0 = 0
        pos2 = n-1
        i = 0
        while i <= pos2:
            if nums[i] == 0:
                nums[i], nums[pos0] = nums[pos0], nums[i]
                pos0 += 1
                i+=1
            elif nums[i] == 2:
                nums[i], nums[pos2] = nums[pos2], nums[i]
                pos2 -= 1
            else:
                i+=1
