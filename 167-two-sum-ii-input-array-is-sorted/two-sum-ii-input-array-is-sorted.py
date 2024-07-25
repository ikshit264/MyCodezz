class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        l = 0
        n = len(numbers)
        r = n - 1
        while numbers[l] + numbers[r] != target:
            temp = numbers[l] + numbers[r]
            if temp > target:
                r-=1
            else:
                l+=1
        return [l+1, r+1]