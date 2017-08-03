class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return 0
            
        tails = [0] * len(nums)
        size = 0
        for x in nums:
            left = 0
            right = size
            while left != right:
                mid = left + (right - left) / 2
                if tails[mid] < x:
                    left = mid + 1
                else:
                    right = mid
            tails[left] = x
            if left == size:
                size += 1
        return size