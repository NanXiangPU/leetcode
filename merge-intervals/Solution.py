# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e
import functools

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        if intervals == None or len(intervals) == 0:
            return []
        res = []
        stack = []
        count = 0
        intervals = sorted(intervals, key = functools.cmp_to_key(self.my_cmp))
        stack.append(intervals[count])
        count += 1
        while count < len(intervals):
            curr = stack[len(stack) - 1]
            next = intervals[count]
            count += 1
            if curr.end < next.start:
                stack.append(next)
            else:
                stack.pop()
                start = curr.start
                end = max(curr.end, next.end)
                interval = Interval(start, end)
                stack.append(interval)
        while len(stack) != 0:
            res.insert(0, stack.pop())
        return res
    
    def my_cmp(self, x, y):
        return x.start - y.start