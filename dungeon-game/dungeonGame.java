public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return 0;
        }
        
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        int row = dp.length - 1, col = dp[0].length - 1;
        for (int i = row; i >= 0; --i) {
            for (int j = col; j >= 0; --j) {
                if (i == row && j == col) {
                    dp[i][j] = dungeon[i][j] >= 0 ? 1 : -dungeon[i][j] + 1;
                } else if (i == row) {
                    dp[i][j] = dp[i][j + 1] - dungeon[i][j] <= 0 ? 1 : dp[i][j + 1] - dungeon[i][j];
                } else if (j == col) {
                    dp[i][j] = dp[i + 1][j] - dungeon[i][j] <= 0 ? 1 : dp[i + 1][j] - dungeon[i][j];
                } else {
                    int small = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = small - dungeon[i][j] <= 0 ? 1 : small - dungeon[i][j];
                }
            }
        }
        
        return dp[0][0];
    }
}