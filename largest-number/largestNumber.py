class Solution:
    # @param {integer[]} nums
    # @return {string}
    def my_cmp(self, x, y):
        str1 = str(x)
        str2 = str(y)
        if str1 + str2 < str2 + str1:
            return 0
        else:
            return -1
    
    def largestNumber(self, nums):
        nums.sort(cmp = self.my_cmp)
        num = [str(x) for x in nums]
        return ''.join(num).lstrip('0') or '0'
        