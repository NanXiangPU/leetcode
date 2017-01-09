class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxHerePre = nums[0]
        minHerePre = nums[0]
        maxSoFar = nums[0]
        
        for i in range(1,len(nums)):
            maxHere = max(max(maxHerePre * nums[i], minHerePre * nums[i]), nums[i])
            minHere = min(min(maxHerePre * nums[i], minHerePre * nums[i]), nums[i])
            maxSoFar = max(maxHere, maxSoFar)
            maxHerePre = maxHere
            minHerePre = minHere
            
        return maxSoFar
