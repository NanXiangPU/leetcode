class Solution(object):
    #time complexity m * log(n)
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return False
        for i in range(len(matrix)):
            left = 0
            right = len(matrix[0]) - 1
            if matrix[i][right] < target:
                continue
            while left + 1 < right:
                mid = left + (right - left) / 2
                if matrix[i][mid] == target:
                    return True
                elif matrix[i][mid] < target:
                    left = mid
                else:
                    right = mid
            if matrix[i][left] == target or matrix[i][right] == target:
                return True
            else:
                return False
        
        return False

    #time complexity log(m) * log(n)
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if matrix == None or len(matrix) == 0:
            return False
        if matrix[0] == None or len(matrix[0]) == 0:
            return False
        
        left = 0
        right = len(matrix) * len(matrix[0]) - 1
        col = len(matrix[0])
        while left + 1 < right:
            mid = left + (right - left) / 2
            num = matrix[mid / col][mid % col]
            if num == target:
                return True
            elif num < target:
                left = mid
            else:
                right = mid
        
        if matrix[left / col][left % col] == target or matrix[right / col][right % col] == target:
            return True
        
        return False
            