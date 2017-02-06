# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None or head.next == None:
            return head
        prev = None
        slow = head
        fast = head
        while fast != None and fast.next != None:
            prev = slow
            slow = slow.next
            fast = fast.next.next
        prev.next = None
        left = self.sortList(head)
        right = self.sortList(slow)
        return self.merge(left, right)
        
    def merge(self, headA, headB):
        res = ListNode(0)
        dummy = res
        while headA != None and headB != None:
            if headA.val < headB.val:
                dummy.next = headA
                headA = headA.next
            else:
                dummy.next = headB
                headB = headB.next
            dummy = dummy.next
        if headA != None:
            dummy.next = headA
        else:
            dummy.next = headB
        
        return res.next
