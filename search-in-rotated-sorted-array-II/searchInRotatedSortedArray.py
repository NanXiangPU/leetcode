class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        if nums == None or len(nums) == 0:
            return False
        left = 0
        right = len(nums) - 1
        while left + 1 < right:
            mid = left + (right - left) / 2
            if nums[mid] == target:
                return True
            if nums[left] == nums[mid]: 
                left += 1    
            elif nums[left] < nums[mid]:
                if nums[left] <= target and target < nums[mid]:
                    right = mid
                else:
                    left = mid
            else:
                if nums[right] >= target and target > nums[mid]:
                    left = mid
                else:
                    right = mid
        if nums[left] == target or nums[right] == target:
            return True
        else:
            return False