/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    //DFS
    private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        if (node.neighbors == null) {
            return map.get(node);
        }
        for (UndirectedGraphNode ugn : node.neighbors) {
            if (!map.containsKey(ugn.label)) {
                clone.neighbors.add(cloneGraph(ugn));
            }
        }
        return clone;
    }

    //BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        if (node.neighbors == null) {
            return map.get(node);
        }
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode pop = queue.poll();
            if (pop.neighbors == null) {
                continue;
            }
            for (UndirectedGraphNode ugn : pop.neighbors) {
                if (!map.containsKey(ugn)) {
                    map.put(ugn, new UndirectedGraphNode(ugn.label));
                    queue.add(ugn);
                }
                UndirectedGraphNode neighborClone = map.get(ugn);
                map.get(pop).neighbors.add(neighborClone);
            }
        }
        return clone;
    }
}