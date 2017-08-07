public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] set = new int[n];
        Arrays.fill(set, -1);
        for (int[] edge : edges) {
            int point1 = find(set,edge[0]);
            int point2 = find(set,edge[1]);
            if (point1 == point2) {
                return false;
            }
            set[point2] = point1;
        }
        return edges.length == n - 1;
    }
    
    public int find(int[] set, int point) {
        if (set[point] == -1) {
            return point;
        }
        return find(set, set[point]);
    }
}