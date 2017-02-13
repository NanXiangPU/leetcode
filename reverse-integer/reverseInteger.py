class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        maxint = (1 << 31) - 1
        minint = - (1 << 31)
        res = 0
        negative = False
        if x < 0:
            negative = True
            x = -x
        while x != 0:
            res *= 10
            res += x % 10
            x //= 10
            if res > maxint or -res < minint:
                return 0
        
        if negative:
            return -res
        else:
            return res
