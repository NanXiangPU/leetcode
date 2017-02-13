# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        dummy1 = odd = head
        dummy2 = even = head.next
        while dummy2 != None and dummy2.next != None:
            dummy1.next = dummy1.next.next
            dummy2.next = dummy2.next.next
            dummy1 = dummy1.next
            dummy2 = dummy2.next
        dummy1.next = even
        
        return odd
        
