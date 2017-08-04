public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] set = new int[n];
        for(int i = 0; i < n; ++i) {
            set[i] = i;
        }
        for(int[] edge : edges) {
            int a = find(set, edge[0]);
            int b = find(set, edge[1]);
            if(a != b) {
                set[a] = b;
                n--;
            }
        }
        return n;
    }
    
    public int find(int[] set, int id) {
        while(set[id] != id) {
            set[id] = set[set[id]];
            id = set[id];
        }
        return id;
    }
}