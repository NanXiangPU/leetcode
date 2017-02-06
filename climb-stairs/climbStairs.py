class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        zero = 1
        one = 1
        if n == 0 or n == 1:
            return 1
        res = 0
        for i in range(1, n):
            res = zero + one
            zero = one
            one = res
        return res
