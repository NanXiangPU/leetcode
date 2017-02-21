# Definition for a point.
# class Point(object):
#     def __init__(self, a=0, b=0):
#         self.x = a
#         self.y = b
from decimal import *

class Solution(object):
    def maxPoints(self, points):
        """
        :type points: List[Point]
        :rtype: int
        """
        maxNum = 0
        if len(points) == 0:
            return maxNum
        for i in range(len(points)):
            point = points[i]
            maxLocal = 0
            overlap = 0
            vertical = 0
            hashmap = {}
            for j in range(i + 1, len(points)):
                pt = points[j]
                if pt.x == point.x and pt.y == point.y:
                    overlap += 1
                    continue
                elif pt.x == point.x and pt.y != point.y:
                    vertical += 1
                    continue
                k = Decimal((pt.y - point.y)) / (pt.x - point.x)
                if k in hashmap:
                    hashmap[k] += 1
                else:
                    hashmap[k] = 1
                maxLocal = max(hashmap[k], maxLocal)
            maxLocal = max(maxLocal, vertical) + overlap + 1
            maxNum = max(maxNum, maxLocal)
        return maxNum
                
