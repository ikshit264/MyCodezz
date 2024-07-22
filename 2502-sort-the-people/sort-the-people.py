class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        names = zip(names, heights)
        names = sorted(names, key=lambda x:x[1], reverse=True)
        return [x[0] for x in names]