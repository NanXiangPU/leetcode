class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        hashmap = {}
        maxLen = 0
        start = 0
        for i in range(len(s)):
            if s[i] in hashmap and start <= hashmap[s[i]]:
                start = hashmap[s[i]] + 1
            else:
                maxLen = max(maxLen, i - start + 1)
            hashmap[s[i]] = i
            
        return maxLen
        
