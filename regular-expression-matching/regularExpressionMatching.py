class Solution(object):
    #dp
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        if p == None:
            return True if s == None else False
        dp = [[False for i in range (len(p) + 1)] for j in range (len(s) + 1)]
        dp[0][0] = True
        for i in range(1, len(dp[0])):
            if i > 1 and p[i - 1] == '*' and dp[0][i - 2] == True:
                dp[0][i] = True
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if p[j - 1] == '.' or s[i - 1] == p[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                elif p[j - 1] == '*':
                    if j > 1:
                        if p[j - 2] != '.' and p[j - 2] != s[i - 1]:
                            dp[i][j] = dp[i][j - 2]
                        else:
                            dp[i][j] = dp[i][j - 1] or dp[i - 1][j] or dp[i][j - 2]
        return dp[len(dp) - 1][len(dp[0]) - 1]

        #recursive
        def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        if len(p) == 0:
            return True if len(s) == 0 else False
        if len(p) == 1:
            return len(s) == 1 and (p[0] == '.' or p[0] == s[0])
        if p[1] != '*':
            return len(s) != 0 and (p[0] == '.' or p[0] == s[0]) and self.isMatch(s[1:], p[1:]) 
        else:
            while len(s) != 0 and (s[0] == p[0] or p[0] == '.'):
                if self.isMatch(s, p[2:]):
                    return True
                s = s[1:]
            return self.isMatch(s, p[2:])