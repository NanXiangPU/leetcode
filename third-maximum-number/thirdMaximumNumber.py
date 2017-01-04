"""
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
"""

class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = []
        for n in set(nums):
            l = sorted(l + [-n])[:3]
            #bisect.insort(l + [-n])
            #del l[3:]
        return -l[2] if len(l)>2 else -l[0]