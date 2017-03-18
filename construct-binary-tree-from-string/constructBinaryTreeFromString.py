# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def str2tree(self, s):
        """
        :type s: str
        :rtype: TreeNode
        """
        if s is None or len(s) == 0:
            return None
        firstParen = s.find('(')
        if firstParen == -1:
            cur = TreeNode(int(s))
            return cur
        else:
            cur = TreeNode(int(s[:firstParen]))
            start = firstParen
            leftParenCount = 0
            for i in range(start, len(s)):
                if s[i] == '(':
                    leftParenCount += 1
                elif s[i] == ')':
                    leftParenCount -= 1
                if leftParenCount == 0 and start == firstParen:
                    cur.left = self.str2tree(s[start + 1:i])
                    start = i + 1
                elif leftParenCount == 0:
                    cur.right = self.str2tree(s[start + 1:i])
        
        return cur