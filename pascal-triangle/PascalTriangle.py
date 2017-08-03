class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        res = []
        if numRows == 0:
            return res
        
        for i in range(numRows):
            if i == 0:
                list = [1]
                res.append(list)
            else:
                pre = res[len(res) - 1]
                list = []
                list.append(pre[0])
                for j in range(1, len(pre)):
                    tmp = pre[j - 1] + pre[j]
                    list.append(tmp)
                list.append(pre[len(pre) - 1])
                res.append(list)
        return res