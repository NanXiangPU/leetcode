class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
        while left + 1 < right:
            mid = left + (right - left) // 2
            if nums[mid] > nums[mid - 1] and nums[mid] > nums[mid + 1]:
                return mid
            elif nums[mid] > nums[mid - 1] and nums[mid] < nums[mid + 1]:
                left = mid
            else:
                right = mid
        if nums[left] > nums[right]:
            return left
        else:
            return right