# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return 0
        left = right = root
        res = h = 0
        while right != None:
            left = left.left
            right = right.right
            h += 1
        if left == None:
            return (1 << h) - 1
        return 1 + self.countNodes(root.left) + self.countNodes(root.right)