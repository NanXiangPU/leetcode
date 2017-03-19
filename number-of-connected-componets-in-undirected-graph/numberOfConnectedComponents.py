class Solution(object):
    def countComponents(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: int
        """
        path = [i for i in range(n)]
        for edge in edges:
            a = self.find(path, edge[0])
            b = self.find(path, edge[1])
            if a != b:
                path[a] = b
                n -= 1
        return n
        
    def find(self, path, value):
        while path[value] != value:
            path[value] = path[path[value]]
            value = path[value]
        return value