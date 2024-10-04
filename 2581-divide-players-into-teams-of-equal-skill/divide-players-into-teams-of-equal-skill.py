class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        skill.sort()
        n = len(skill)
        check = skill[0] + skill[-1]
        result = 0

        for i in range((n + 1)//2):
            ye = skill[i] + skill[n-i-1]
            print(i)
            if not ye ==  check:
                return -1
            result += skill[i] * skill[n-i-1]
        
        return result