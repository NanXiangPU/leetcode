class Solution(object):
    def inorderSuccessor(self, root, p):
        """
        :type root: TreeNode
        :type p: TreeNode
        :rtype: TreeNode
        """
        if root == None:
            return None
        
        if p.val >= root.val:
            return self.inorderSuccessor(root.right, p)
        else:
            left = self.inorderSuccessor(root.left, p)
            if left == None:
                return root
            else:
                return left
                