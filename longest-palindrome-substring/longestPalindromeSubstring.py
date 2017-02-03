class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        res = ""
        maxLen = 0
        for i in range(0, len(s)):
            odd = self.expand(s, i, i)
            even = self.expand(s, i, i + 1)
            if len(odd) >= maxLen:
                res = odd
                maxLen = len(odd)
            if len(even) >= maxLen:
                res = even
                maxLen = len(even)
        return res;
    
    
    def expand(self, s, i, j):
        while i >= 0 and j < len(s) and s[i] == s[j]:
            i -= 1
            j += 1
        return s[i + 1: j]
