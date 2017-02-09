class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        res = ""
        count = num // 1000
        for i in range(count):
            res += 'M'
        num -= count * 1000
        count = num // 900
        for i in range(count):
            res += 'CM'
        num -= count * 900
        count = num // 500
        for i in range(count):
            res += 'D'
        num -= count * 500
        count = num // 400
        for i in range(count):
            res += 'CD'
        num -= count * 400
        count = num // 100
        for i in range(count):
            res += 'C'
        num -= count * 100
        count = num // 90
        for i in range(count):
            res += 'XC'
        num -= count * 90
        count = num // 50
        for i in range(count):
            res += 'L'
        num -= count * 50
        count = num // 40
        for i in range(count):
            res += 'XL'
        num -= count * 40
        count = num // 10
        for i in range(count):
            res += 'X'
        num -= count * 10
        count = num // 9
        for i in range(count):
            res += 'IX'
        num -= count * 9
        count = num // 5
        for i in range(count):
            res += 'V'
        num -= count * 5
        count = num // 4
        for i in range(count):
            res += 'IV'
        num -= count * 4
        count = num
        for i in range(count):
            res += 'I'
        return res
