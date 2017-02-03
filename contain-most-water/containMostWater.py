class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        left = 0
        right = len(height) - 1
        most = (right - left) * min(height[left], height[right])
        while left < right:
            if height[left] > height[right]:
                right -= 1
                most = max((right - left) * min(height[left], height[right]), most)
            else:
                left += 1
                most = max((right - left) * min(height[left], height[right]), most)
        return most
