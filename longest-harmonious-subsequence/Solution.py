class Solution:
    def findLHS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return 0
        map = {}
        res = 0
        for i in nums:
            if i in map:
                map[i] += 1
            else:
                map[i] = 1
        for k in map.keys():
            if k + 1 in map:
                res = max(res, map[k] + map[k + 1])
        return res;