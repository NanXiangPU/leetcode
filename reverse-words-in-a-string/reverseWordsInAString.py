class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        parts = s.strip().split()
        res = ""
        for i in range(len(parts) - 1, 0, -1):
            res += parts[i] + " "
        if len(parts) == 0:
            return res
        else:
            return res + parts[0]
