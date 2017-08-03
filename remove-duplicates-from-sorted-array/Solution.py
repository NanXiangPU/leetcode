class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None:
            return 0
        if len(nums) < 2:
            return len(nums)
        
        size = 1
        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:
                continue
            nums[size] = nums[i]
            size += 1
        return size