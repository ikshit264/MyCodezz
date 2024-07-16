# because size of array doest not exceede the size of n[i] for each elem we can check the index of each elem
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            temp = abs(nums[i])
            if(nums[temp] < 0) : return temp
            nums[temp] = -nums[temp]
        return -1
        