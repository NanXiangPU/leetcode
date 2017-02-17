class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        maxFac = 5
        res = 0
        while maxFac <= n:
            res += n // maxFac
            maxFac *= 5
        return res
