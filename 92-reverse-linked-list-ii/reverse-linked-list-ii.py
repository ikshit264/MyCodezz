# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        LeftPrev, curr = dummy, head

        for _ in range(left-1):
            LeftPrev, curr = curr, curr.next
        
        prev = None

        for _ in range(right-left+1):
            temp = curr.next
            curr.next = prev
            prev, curr = curr, temp
        
        LeftPrev.next.next = curr
        LeftPrev.next = prev
        return dummy.next