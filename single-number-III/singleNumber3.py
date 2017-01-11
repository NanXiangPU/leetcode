class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        diff = reduce(lambda x, y: x ^ y, nums)
        diff &= -diff
        return [reduce(lambda x, y: x ^ y, [i for i in nums if i & diff == 0]), reduce(lambda x, y: x ^ y, [i for i in nums if i & diff != 0])]
