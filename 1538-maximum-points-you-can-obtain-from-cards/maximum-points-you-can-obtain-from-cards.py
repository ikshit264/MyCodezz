class Solution:
    def maxScore(self, store: List[int], k: int) -> int:
        n = len(store)
        
        prefix_sums = [0] * (n + 1)
        for i in range(1, n + 1):
            prefix_sums[i] = prefix_sums[i - 1] + store[i - 1]
        
        suffix_sums = [0] * (n + 1)
        for i in range(1, n + 1):
            suffix_sums[i] = suffix_sums[i - 1] + store[n - i]
        
        max_score = 0
        
        for i in range(k + 1):
            max_score = max(max_score, prefix_sums[i] + suffix_sums[k - i])
        
        return max_score