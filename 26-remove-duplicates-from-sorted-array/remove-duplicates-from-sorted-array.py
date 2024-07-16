class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        start = 0
        for i in range(start, len(nums)):
            if nums[i] != nums[start]:
                nums[start+1] = nums[i]
                start+=1
        return start+1