class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return -1
        left = 0
        right = len(nums) - 1
        while left + 1 < right:
            mid = left + (right - left) / 2
            if nums[mid] == target:
                return mid
            if nums[left] < nums[mid]:
                if target >= nums[left] and target < nums[mid]:
                    right = mid
                else:
                    left = mid
            else:
                if target <= nums[right] and target > nums[mid]:
                    left = mid
                else:
                    right = mid
        if nums[left] == target:
            return left
        elif nums[right] == target:
            return right
        else:
            return - 1