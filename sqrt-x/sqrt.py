class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 0:
            return 0
        elif x < 0:
            raise ValueError("Invalid input")
            
        left = 1
        right = x
        while left + 1 < right:
            mid = left + (right - left) / 2
            if mid == x / mid or (mid < x / mid and (mid + 1) > x / (mid + 1)):
                return mid
            elif mid < x / mid:
                left = mid
            else:
                right = mid
        if left == x / left or (left < x / left and (left + 1) > x / (left + 1)):
            return left
        else:
            return right