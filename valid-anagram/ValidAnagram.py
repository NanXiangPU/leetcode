class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if s == None and t == None:
            return True
        elif s == None and t != None or s != None and t == None or len(s) != len(t):
            return False
        
        letters = [0] * 26
        for c in s:
            letters[ord(c) - ord('a')] += 1
        for c in t:
            letters[ord(c) - ord('a')] -= 1
        for i in letters:
            if i != 0:
                return False
        return True