class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        res = ""
        pt1 = len(a) - 1
        pt2 = len(b) - 1
        carry = 0
        while pt1 >= 0 or pt2 >= 0:
            tmp = carry
            if pt1 >= 0:
                tmp += ord(a[pt1]) - ord('0')
                pt1 -= 1
            if pt2 >= 0:
                tmp += ord(b[pt2]) - ord('0')
                pt2 -= 1
            res += str(tmp % 2)
            carry = tmp // 2
        if carry == 1:
            res += "1"
        return res[::-1]