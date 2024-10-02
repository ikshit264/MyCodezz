# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        left = ListNode(0)
        cur_left = left
        right = ListNode(0)
        cur_right = right

        current = head

        while current:
            if current.val < x:
                cur_left.next = current
                cur_left = cur_left.next 
            elif current.val >= x:
                cur_right.next = current
                cur_right = cur_right.next

            current = current.next
        cur_right.next = None
        cur_left.next = right.next
        
        return left.next