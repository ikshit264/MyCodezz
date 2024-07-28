class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        sums = 0
        store = {0 : 1} # if anything is (0, i) = k then this condition works
        for i in nums:
            sums += i
            if (sums - k) in store:
                count += store[sums-k]
            if sums in store:
                store[sums] += 1
            else:
                store[sums] = 1
        return count