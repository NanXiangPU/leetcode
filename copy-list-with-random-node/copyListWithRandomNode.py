# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
	#O(n) space, O(n) time with hashmap
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if head == None:
            return None
        dic = {}
        dummy = head
        while dummy != None:
            dic[dummy] = RandomListNode(dummy.label)
            dummy = dummy.next
        
        dummy = head
        while dummy != None:
            dic[dummy].next = dic.get(dummy.next)
            dic[dummy].random = dic.get(dummy.random)
            dummy = dummy.next
            
        return dic.get(head)

    #O(1) space, O(n) time iterative
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        dummy = head
        while dummy != None:
            next = dummy.next
            dummy.next = RandomListNode(dummy.label)
            dummy.next.next = next
            dummy = next
        
        dummy = head
        while dummy != None:
            if dummy.random != None:
                dummy.next.random = dummy.random.next
            dummy = dummy.next.next
        
        res = RandomListNode(0)
        copy = res
        dummy = head
        while dummy != None:
            next = dummy.next.next
            copy.next = dummy.next
            copy = copy.next
            dummy.next = dummy.next.next
            dummy = next
        
        return res.next 