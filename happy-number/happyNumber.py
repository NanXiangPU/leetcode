class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        hashset = []
        while n != 1:
            if n in hashset:
                return False
            else:
                hashset.append(n)
            newNum = 0
            for c in str(n):
                newNum += pow(int(c), 2)
            n = newNum
        return True
