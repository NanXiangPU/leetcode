class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        if divisor == 0:
            raise ValueError("Invalid input")
        MAX_INT = (1 << 31) - 1
        MIN_INT = -(1 << 31)
        
        res = 0
        positive = (dividend < 0) is (divisor < 0)
        dividend = abs(dividend)
        divisor = abs(divisor)
        while dividend >= divisor:
            tmp, i = divisor, 1
            while dividend >= tmp:
                dividend -= tmp
                res += i
                if (positive and res > MAX_INT) or (not positive and res < MIN_INT):
                    return MAX_INT
                tmp <<= 1
                i <<= 1
        
        if positive:
            return res
        else:
            return -res