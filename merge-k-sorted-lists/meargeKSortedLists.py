class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        from heapq import heappush, heappop, heapreplace, heapify
        head = dummy = ListNode(0)
        h = [(li.val, li) for li in lists if li]
        heapify(h)
        while h:
            v, n = h[0]
            if n.next is None:
                heappop(h)
            else:
                heapreplace(h, (n.next.val, n.next))
            dummy.next = n
            dummy = dummy.next
    
        return head.next
            