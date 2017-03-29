class ZigzagIterator(object):

    def __init__(self, v1, v2):
        """
        Initialize your data structure here.
        :type v1: List[int]
        :type v2: List[int]
        """
        self.queue = []
        i = j = 0
        while i < len(v1) or j < len(v2):
            if i < len(v1):
                self.queue.insert(0, v1[i])
                i += 1
            if j < len(v2):
                self.queue.insert(0, v2[j])
                j += 1

    def next(self):
        """
        :rtype: int
        """
        return self.queue.pop()

    def hasNext(self):
        """
        :rtype: bool
        """
        if len(self.queue) == 0:
            return False
        else:
            return True

# Your ZigzagIterator object will be instantiated and called as such:
# i, v = ZigzagIterator(v1, v2), []
# while i.hasNext(): v.append(i.next())