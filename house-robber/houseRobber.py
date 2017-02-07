class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0;
        maxTake = nums[0]
        maxNotTake = 0
        maxSoFar = max(maxTake, maxNotTake)
        for i in range(1, len(nums)):
            tmp = maxNotTake
            maxNotTake = max(maxTake, maxNotTake)
            maxTake = tmp + nums[i]
            maxSoFar = max(maxNotTake, maxTake)
        return maxSoFar
