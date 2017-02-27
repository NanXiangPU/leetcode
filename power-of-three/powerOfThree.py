class Solution(object):
    #recursive
    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n < 1:
            return False
        if n == 1:
            return True
        return self.isPowerOfThree(n / 3.0)

    #iterative
    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        while n > 1:
            n = n / 3.0
        if n < 1:
            return False
        else:
            return True
        
    #math
    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return (n > 0 and 1162261467 % n == 0)