class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        res = 0
        minNum = sys.maxint
        for i in range(len(prices)):
            if prices[i] < minNum:
                minNum = prices[i]
            res = max(res, prices[i] - minNum)
        return res
        
