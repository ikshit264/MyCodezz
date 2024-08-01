class Solution:
    def countSeniors(self, details: List[str]) -> int:
        result = sum(1 for i in range(len(details)) if int(details[i][11:13]) > 60)
        return result