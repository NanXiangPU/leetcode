class Solution(object):
    def calculateMinimumHP(self, dungeon):
        """
        :type dungeon: List[List[int]]
        :rtype: int
        """
        if dungeon == None or len(dungeon) == 0 or dungeon[0] == None or len(dungeon[0]) == 0:
            return 0;
        dp = [[0] * len(dungeon[0])] * len(dungeon)
        for i in range(len(dungeon) - 1, -1, -1):
            for j in range(len(dungeon[0]) - 1, -1, -1):
                if i == len(dungeon) - 1 and j == len(dungeon[0]) - 1:
                    if dungeon[i][j] > 0:
                        dp[i][j] = 1
                    else:
                        dp[i][j] = -dungeon[i][j] + 1
                elif i == len(dungeon) - 1:
                    if dp[i][j + 1] - dungeon[i][j] > 0:
                        dp[i][j] = dp[i][j + 1] - dungeon[i][j]
                    else:
                        dp[i][j] = 1
                elif j == len(dungeon[0]) - 1:
                    if dp[i + 1][j] - dungeon[i][j] > 0:
                        dp[i][j] = dp[i + 1][j] - dungeon[i][j]
                    else:
                        dp[i][j] = 1
                else:
                    small = min(dp[i + 1][j], dp[i][j + 1])
                    if small - dungeon[i][j] > 0:
                        dp[i][j] = small - dungeon[i][j]
                    else:
                        dp[i][j] = 1
        
        return dp[0][0]