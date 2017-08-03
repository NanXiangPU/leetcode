public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
            return null;
        }
        if (B == null || B.length == 0 || B[0] == null || B[0].length == 0) {
            return null;
        }
        int m = A.length, n = A[0].length;
        int mB = B.length, nB = B[0].length;
        int[][] res = new int[m][nB];
        List[] lists = new List[m];
        for (int i = 0; i < m; ++i) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (A[i][j] != 0) {
                    list.add(j);
                    list.add(A[i][j]);
                } 
            }
            lists[i] = list;
        }
        
        for (int i = 0; i < lists.length; ++i) {
            List<Integer> list = lists[i];
            for (int j = 0; j < list.size() - 1; j += 2) {
                int colA = list.get(j);
                int valA = list.get(j + 1);
                for (int p = 0; p < B[0].length; ++p) {
                    int valB = B[colA][p];
                    res[i][p] += valA * valB;
                }
            }
        } 
        return res;
    }
}