class Solution(object):
    #iterative
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        strs = [" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        res = []
        for i in range(len(digits)):
            char = digits[i]
            num = int(char)
            str = strs[num]
            if len(res) == 0:
                for j in range(len(str)):
                    res.insert(0, str[j])
            else:
                size = len(res)
                for j in range(size):
                    curr = res.pop()
                    for p in range(len(str)):
                        res.insert(0, curr + str[p])
        
        return res

    #recursive
    strs = [" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        if len(digits) == 0:
            return []
        res = []
        self.helper("", digits, res, 0)
        return res
    
    def helper(self, curr, digits, res, index):
        if index >= len(digits):
            res.append(curr)
            return
        str = self.strs[int(digits[index])]
        for i in range(len(str)):
            self.helper(curr + str[i], digits, res, index + 1)