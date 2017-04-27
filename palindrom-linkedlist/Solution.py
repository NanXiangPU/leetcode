# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head == None or head.next == None:
            return True
        size = 0
        dummy = head
        while dummy:
            size += 1
            dummy = dummy.next
        dummy = head
        for i in range((size - 1) / 2):
            dummy = dummy.next
        mid = dummy.next
        dummy.next = None
        
        dummy = head
        mid = self.reverse(mid)
        while mid:
            if dummy.val != mid.val:
                return False
            dummy = dummy.next
            mid = mid.next
        return True
        
    def reverse(self, head):
        res = None
        dummy = head
        while dummy:
            next = dummy.next
            dummy.next = res
            res = dummy
            dummy = next
        return res