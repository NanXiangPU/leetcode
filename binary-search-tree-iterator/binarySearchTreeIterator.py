# Definition for a  binary tree node
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        self.pushAll(root)

    def hasNext(self):
        """
        :rtype: bool
        """
        if len(self.stack) == 0:
            return False
        else:
            return True

    def next(self):
        """
        :rtype: int
        """
        node = self.stack.pop()
        self.pushAll(node.right)
        return node.val
        
    def pushAll(self, node):
        dummy = node
        while dummy != None:
            self.stack.append(dummy)
            dummy = dummy.left

# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())