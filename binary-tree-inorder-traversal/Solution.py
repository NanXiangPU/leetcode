# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        if root == None:
            return res
        stack = []
        dummy = root
        while dummy != None:
            stack.append(dummy)
            dummy = dummy.left
        while len(stack) > 0:
            node = stack.pop()
            res.append(node.val)
            if node.right != None:
                dummy = node.right
                while dummy != None:
                    stack.append(dummy)
                    dummy = dummy.left
        return res