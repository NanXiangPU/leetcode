class Solution(object):
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return 0
        nums = sorted(nums)
        sum = 0
        for i in range(0, len(nums), 2):
            sum += nums[i]
        return sum