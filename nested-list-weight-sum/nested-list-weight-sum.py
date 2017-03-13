# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class Solution(object):
    #dfs
    def depthSum(self, nestedList):
        """
        :type nestedList: List[NestedInteger]
        :rtype: int
        """
        return self.dfs(nestedList, 1)
    
    def dfs(self, nestedList, depth):
        res = 0
        for n in nestedList:
            if n.isInteger():
                res += depth * n.getInteger()
            else:
                res += self.dfs(n.getList(), depth + 1)
        return res

    #bfs
    def depthSum(self, nestedList):
        """
        :type nestedList: List[NestedInteger]
        :rtype: int
        """
        res = 0
        depth = 1
        count = 0
        while nestedList:
            nextList = []
            for ni in nestedList:
                if ni.isInteger():
                    res += depth * ni.getInteger()
                else:
                    nextList.extend(ni.getList())
            depth += 1
            nestedList = nextList
            
        return res