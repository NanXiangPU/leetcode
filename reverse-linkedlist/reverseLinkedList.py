class Solution(object):
	#recursive
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        return self.reverse(head, None)
    
    def reverse(self, head, newHead):
        if head == None:
            return newHead
        next = head.next
        head.next = newHead
        return self.reverse(next, head)

	#iterative
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        newHead = None
        while head != None:
            next = head.next
            head.next = newHead
            newHead = head
            head = next
        return newHead
