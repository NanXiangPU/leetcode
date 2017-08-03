class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        res = []
        self.backTrack(res, "", 0, 0, n)
        return res
        
    def backTrack(self, res, curStr, open, close, max):
        if len(curStr) == max * 2:
            res.append(curStr)
        
        if open < max:
            self.backTrack(res, curStr + "(", open + 1, close, max)
        if close < open:
            self.backTrack(res, curStr + ")", open, close + 1, max)