public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int height = nums.length, width = nums[0].length;
        if (r == 0 || c == 0 || (r * c) != (height * width)) {
            return nums;
        }
        int[][] res = new int[r][c];
        int[] values = new int[height * width];
        int count = 0;
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                values[count++] = nums[i][j];
            }
        }
        count = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                res[i][j] = values[count++];
            }
        }
        return res;
    }
}