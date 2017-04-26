class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        if matrix == None or len(matrix) == 0 or matrix[0] == None or len(matrix[0]) == 0:
            return
        
        size = len(matrix)
        for i in range(size):
            for j in range(size - i):
                matrix[i][j], matrix[size - j - 1][size - i - 1] = matrix[size - j - 1][size - i - 1], matrix[i][j]
        for i in range(size / 2):
            for j in range(size):
                matrix[i][j], matrix[size - i - 1][j] = matrix[size - i - 1][j], matrix[i][j]
        