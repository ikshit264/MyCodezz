# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy_head = ListNode(0)
        current = dummy_head
        carry = 0

        while l1 or l2:
            value1 = l1.val if l1 else 0
            value2 = l2.val if l2 else 0

            total = value1 + value2 + carry
            carry = total // 10  # check if carry generated 11 -> 1, 14 -> 1
            current.next = ListNode(total%10)  # check if 
            current = current.next

            if l1: l1 = l1.next
            if l2: l2 = l2.next

        if carry > 0: current.next = ListNode(carry)

        return dummy_head.next
