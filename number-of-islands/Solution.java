public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        boolean[][] visited = new boolean[height][width];
        int count = 0;
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    helper(i ,j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void helper(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1' || visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;
        helper(i + 1, j, grid, visited);
        helper(i - 1, j, grid, visited);
        helper(i, j + 1, grid, visited);
        helper(i, j - 1, grid, visited);
    }
}