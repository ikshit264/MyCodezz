class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy=float('inf')
        profitt=float('-inf')
        for p in prices:
            buy=min(buy,p)
            profitt=max(profitt,p-buy)
        return profitt