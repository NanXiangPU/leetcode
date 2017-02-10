class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        num = "1"
        newNum = num
        if n <= 1:
            return newNum
        for i in range(1, n):
            p = 0
            q = 1
            count = 1
            newNum = ""
            while q < len(num):
                if num[q] == num[p]:
                    count += 1
                else:
                    newNum += str(count) + num[p]
                    p = q
                    count = 1
                q += 1
            newNum += str(count) + num[p]
            num = newNum
        return newNum
