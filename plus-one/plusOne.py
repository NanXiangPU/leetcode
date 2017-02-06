class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        res = []
        carry = 1
        for i in range(len(digits) - 1, -1, -1):
            res.insert(0, (carry + digits[i]) % 10)
            carry = (carry + digits[i]) // 10
        if carry == 1:
            res.insert(0, 1)
        return res
