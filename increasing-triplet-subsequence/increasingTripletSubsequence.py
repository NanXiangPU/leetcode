class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if nums == None or len(nums) < 3:
            return False
            
        first = second = (1 << 31) - 1
        for i in range(len(nums)):
            if nums[i] <= first:
                first = nums[i]
            elif nums[i] <= second:
                second = nums[i]
            else:
                return True
        return False