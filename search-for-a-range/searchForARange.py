class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if nums == None or len(nums) == 0:
            return [-1, -1]
        left = 0
        right = len(nums) - 1
        res = []
        while left + 1 < right:
            mid = left + (right - left) / 2
            if nums[mid] == target:
                right = mid
            elif nums[mid] > target:
                right = mid
            else:
                left = mid
        if nums[left] == target:
            res.append(left)
        elif nums[right] == target:
            res.append(right)
        else:
            res.append(-1)
            
        left = 0
        right = len(nums) - 1
        while left + 1 < right:
            mid = left + (right - left) / 2
            if nums[mid] == target:
                left = mid
            elif nums[mid] > target:
                right = mid
            else:
                left = mid
        if nums[right] == target:
            res.append(right)
        elif nums[left] == target:
            res.append(left)
        else:
            res.append(-1)
            
        return res