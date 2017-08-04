class Solution(object):
    def myCmp(self, x, y):
        if x[0] == y[0]:
            return y[1] - x[1]
        else:
            return x[0] - y[0]
            
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        if envelopes == None or len(envelopes) == 0 or envelopes[0] == None or len(envelopes[0]) == 0:
            return 0
        
        envelopes.sort(cmp=self.myCmp)
        
        size = 0
        dp = [0] * len(envelopes)
        for x in envelopes:
            left = 0
            right = size
            i = bisect.bisect_left(dp, x[1], 0, size)
            dp[i] = x[1]
            if i == size:
                size += 1
                
        return size