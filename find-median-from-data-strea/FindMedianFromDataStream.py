from Queue import PriorityQueue

class MedianFinder(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.large = PriorityQueue()
        self.small = PriorityQueue()

    def addNum(self, num):
        """
        :type num: int
        :rtype: void
        """
        self.large.put(num)
        self.small.put(-self.large.get())
        if self.small.qsize() > self.large.qsize():
            self.large.put(-self.small.get())

    def findMedian(self):
        """
        :rtype: float
        """
        if (self.small.qsize() + self.large.qsize()) % 2 == 0:
            a = -self.small.get()
            self.small.put(-a)
            b = self.large.get()
            self.large.put(b)
            return (a + b) / 2.0
        else:
            a = self.large.get()
            self.large.put(a)
            return a / 1.0