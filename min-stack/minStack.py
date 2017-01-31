class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.minStack = []
        self.minVal = 0
        

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        if len(self.minStack) == 0:
            self.minVal = x
            self.minStack.append(0)
        else:
            self.minStack.append(x - self.minVal)
            if x < self.minVal:
                self.minVal = x
            

    def pop(self):
        """
        :rtype: void
        """
        element = self.minStack.pop()
        if element < 0:
            self.minVal = self.minVal - element

    def top(self):
        """
        :rtype: int
        """
        if len(self.minStack) == 0:
            return None
        elif self.minStack[len(self.minStack) - 1] < 0:
            return self.minVal
        else:
            return self.minStack[len(self.minStack) - 1] + self.minVal

    def getMin(self):
        """
        :rtype: int
        """
        return self.minVals
