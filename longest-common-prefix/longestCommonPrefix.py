class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        res = ""
        count = 0
        minLen = sys.maxint
        if len(strs) == 0 or len(strs[0]) == 0:
            return ""
        for i in range(len(strs)):
            minLen = min(minLen, len(strs[i]))
        while count < minLen:
            letter = strs[0][count]
            for i in range(len(strs)):
                if count >= len(strs[i]):
                    return res
                if strs[i][count] != letter:
                    return res
            res += letter
            count += 1
        return res
            
