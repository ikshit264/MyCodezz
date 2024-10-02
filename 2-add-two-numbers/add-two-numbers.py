# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        num1 = ""
        num2 = ""
        current = l1
        while current:
            num1+= str(current.val)
            current = current.next
        current = l2
        while current:
            num2+= str(current.val)
            current = current.next
        total = int(num1[::-1]) + int(num2[::-1])

        total_str = str(total)[::-1]
        dummy_head = ListNode()
        current = dummy_head
        
        for digit in total_str:
            current.next = ListNode(int(digit))
            current = current.next
            
        return dummy_head.next
