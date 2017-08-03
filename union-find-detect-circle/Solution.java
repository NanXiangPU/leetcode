import java.util.*;

public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        List<Integer> second = new ArrayList<>();
        second.add(2);
        List<Integer> third = new ArrayList<>();
        third.add(0);
        graph.put(0, first);
        graph.put(1, second);
        graph.put(2, third);
        System.out.println(hasCycle(graph));
     }
     
     public static boolean hasCycle(Map<Integer, List<Integer>> map) {
        int[] graph = new int[map.size() + 1];
        for (int i = 0; i < graph.length; ++i) {
            graph[i] = -1;
        }
        for (Integer i : map.keySet()) {
            List<Integer> neighbors = map.get(i);
            for (Integer j : neighbors) {
                int x = find(graph, i);
                int y = find(graph, j);
                if (x == y) {
                    return true;
                }
                union(graph, i, j);
            }
        }
        return false;
     }
     
     public static int find(int[] graph, int i) {
         if (graph[i] == -1) {
             return i;
         }
         return find(graph, graph[i]);
     }
     
     public static void union(int[] graph, int i, int j) {
         int a = find(graph, i);
         int b = find(graph, j);
         graph[a] = b;
     }
}
