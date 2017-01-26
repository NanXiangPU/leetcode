class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1 or numRows >= len(s):
            return s
        
        res = ""
        for i in range(numRows):
            j = 0
            if i == 0 or i == numRows - 1:
                while i + j * 2 * (numRows - 1) < len(s):
                    res += s[i + j * 2 * (numRows - 1)]
                    j += 1
            else:
                flip = True
                step1 = 2 * (numRows - i - 1)
                step2 = 2 * i
                step = step1
                start = i
                res += s[start]
                while start + step < len(s):
                    res += s[start + step]
                    start = start + step
                    flip = not flip
                    if flip == False:
                        step = step2
                    else:
                        step = step1
                    j += 1
                    
        return res
