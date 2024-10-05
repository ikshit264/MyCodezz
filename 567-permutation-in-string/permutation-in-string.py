from collections import Counter

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        store = Counter(s1)

        def checkForString(checker):
            temp = Counter(checker)
            if temp == store:
                return True
            return False
        
        s1_len = len(s1)

        l = 0
        r = s1_len

        s2_len = len(s2)

        while r < s2_len + 1:
            if checkForString(s2[l : r]):
                return True
            r+=1
            l+=1

        return False
        