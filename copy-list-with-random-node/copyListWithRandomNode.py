# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
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