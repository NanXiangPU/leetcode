class Solution(object):
	#O(n) space O(n) time
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) < 1:
            return 0
        left = list(range(len(height)))
        right = list(range(len(height)))
        res = 0
        
        left[0] = height[0]
        for i in range(1, len(height)):
            left[i] = max(left[i - 1], height[i])
        
        right[len(right) - 1] = height[len(height) - 1]
        for i in range(len(height) - 2, -1, -1):
            right[i] = max(right[i + 1], height[i])
            
        for i in range(len(height)):
            res += min(left[i], right[i]) - height[i]
        
        return res
	
	#O(1) space, O(n) time
	def trap(self, height):
		"""
		:type height: List[int]
		:rtype: int
		"""
		if len(height) < 1:
		    return 0
		res = 0
		leftMax = 0
		rightMax = 0
		i = 0
		j = len(height) - 1
		while i < j and height[i + 1] > height[i]:
		    i += 1
		while i < j and height[j - 1] > height[j]:
		    j -= 1
		while i <= j:
		    leftMax = max(leftMax, height[i])
		    rightMax = max(rightMax, height[j])
		    if leftMax < rightMax:
		        res += leftMax - height[i]
		        i += 1
		    else:
		        res += rightMax - height[j]
		        j -= 1
		return res

	#stack
	    def trap(self, height):
		"""
		:type height: List[int]
		:rtype: int
		"""
		if len(height) < 1:
		    return 0
		stack = []
		res = 0
		i = 0
		while i < len(height):
		    if len(stack) == 0 or height[i] <= height[stack[len(stack) - 1]]:
		        stack.append(i)
		        i += 1
		    else:
		        index = stack.pop()
		        if len(stack) == 0:
		            res += 0
		        else:
		            res += (min(height[stack[len(stack) - 1]], height[i]) - height[index]) * (i - stack[len(stack) - 1] - 1)
		return res
		    
