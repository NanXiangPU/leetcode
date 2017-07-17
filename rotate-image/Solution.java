public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col - i; ++j) {
                swap(matrix, i, j, row - j - 1, col - i - 1);
            }
        }
        for (int i = 0; i < row / 2; ++i) {
            for (int j = 0; j < col; ++j) {
                swap(matrix, i, j, row - i - 1, j);
            }
        }
    }
    
    public void swap(int[][] matrix, int i, int j, int p, int q) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = tmp;
    }
}