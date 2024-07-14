class Solution:
    def getSmallestString(self, s: str) -> str:
        def swap(s, i, j):
            lst = list(s)
            lst[i], lst[j] = lst[j], lst[i]
            return ''.join(lst)
        n = len(s)
        smallest = s
        for i in range(n - 1):
            a = int(s[i])
            b = int(s[i + 1])
            if a > b and a%2 == b%2:
                smallest = min(smallest, swap(s, i, i + 1))
        return smallest
    
        