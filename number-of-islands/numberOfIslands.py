class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.dfsMark(grid, i, j)
                    res += 1
        return res
        
    def dfsMark(self, grid, row, col):
        if row < 0 or col < 0 or row >= len(grid) or col >= len(grid[0]) or grid[row][col] != '1':
            return;
        else:
            grid[row][col] = '0'
            self.dfsMark(grid, row - 1, col)
            self.dfsMark(grid, row + 1, col)
            self.dfsMark(grid, row, col - 1)
            self.dfsMark(grid, row, col + 1)