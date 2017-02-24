class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left = 0
        right = len(nums) - 1
        while left < right - 1:
            mid = left + (right - left) // 2
            if nums[mid] > nums[left]:
                if nums[mid] > nums[right]:
                    left = mid
                else:
                    right = mid
            else:
                if nums[mid] > nums[right]:
                    left = mid
                else:
                    right = mid
        if nums[left] < nums[right]:
            return nums[left]
        else:
            return nums[right]