class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
	#recursive
        if root:
            root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
            return root

	#DFS
	def invertTree(self, root):
		"""
		:type root: TreeNode
		:rtype: TreeNode
		"""
		stack = [root]
		while stack:
		    node = stack.pop()
		    if node:
		        node.left, node.right = node.right, node.left
		        stack += node.left, node.right
		return root

	#BFS
	def invertTree(self, root):
		"""
		:type root: TreeNode
		:rtype: TreeNode
		"""
		queue = collections.deque([root])
		while queue:
		    node = queue.popleft()
		    if node:
		        node.left, node.right = node.right, node.left
		        queue += node.left, node.right
		return root
