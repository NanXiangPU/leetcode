import java.util.*;

public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        List<Integer> second = new ArrayList<>();
        second.add(2);
        
        graph.put(0, first);
        graph.put(1, second);
        
        System.out.println(hasCycle(graph));
     }
     
     public static boolean hasCycle(Map<Integer, List<Integer>> map) {
        boolean[] visited = new boolean[map.size() + 1];
        for (Integer i : map.keySet()) {
            if (helper(map, i, visited, -1)) {
                return true;
            }
        }
        return false;
     }
     
     public static boolean helper(Map<Integer, List<Integer>> map, int i, boolean[] visited, int parent) {
         visited[i] = true;
         List<Integer> list = map.get(i);
         for (Integer p : list) {
             if (!visited[p]) {
                 return helper(map, p, visited, i);
             } else {
                 return i != parent;
             }
         }
         visited[i] = false;
         return false;
     }
}