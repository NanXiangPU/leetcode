class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        if str == None:
            return 0
        str = str.strip()
        if len(str) == 0:
            return 0
        
        max_int = (1 << 31) - 1
        min_int = -(1 << 31)
        res = 0
        negative = True if str[0] == '-' else False
        for i in range(len(str)):
            if i == 0 and (str[i] == '-' or str[i] == '+'):
                continue
            if ord(str[i]) - ord('0') > 9 or ord(str[i]) - ord('0') < 0:
                return res if not negative else -res
            res = 10 * res + ord(str[i]) - ord('0')
            if not negative and res > max_int:
                return max_int
            if negative and -res < min_int:
                return min_int
        
        return res if not negative else -res