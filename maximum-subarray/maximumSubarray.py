class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxSoFar = maxHere = nums[0]
        for i in range(1, len(nums)):
            maxHere = max(nums[i], maxHere + nums[i])
            maxSoFar = max(maxHere, maxSoFar)
        return maxSoFar
        
