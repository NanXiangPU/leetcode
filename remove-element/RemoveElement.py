class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        pt = 0
        for i in range(0, len(nums)):
            if nums[i] != val:
                nums[pt] = nums[i]
                pt += 1
            
        return pt