/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    //recursive DFS
    private String NN = "null";
    private String splitter = ",";
    // Encodes a tree to a single string.
    public void buildString(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append(NN).append(splitter);
        } else {
            sb.append(root.val).append(splitter);
            buildString(sb, root.left);
            buildString(sb, root.right);
        }
    }
    
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        return sb.toString();
    }

    public TreeNode buildTree(Deque<String> data) {
        String val = data.remove();
        if (val.equals(NN)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(data);
        node.right = buildTree(data);
        return node;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(splitter)));
        return buildTree(nodes);
    }

    //BFS
    private String NN = "null";
    private String splitter = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                sb.append(NN).append(splitter);
                continue;
            }
            sb.append(node.val).append(splitter);
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<TreeNode> queue = new LinkedList<>();
        String[] nodes = data.split(splitter);
        int i = 1;
        if (nodes[0].equals(NN)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        while (!queue.isEmpty()) {
            Deque<TreeNode> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                String next = nodes[i];
                if (next.equals(NN)) {
                    node.left = null;
                } else {
                    TreeNode left = new TreeNode(Integer.parseInt(next));
                    node.left = left;
                    nextQueue.add(left);
                }
                i++;
                next = nodes[i];
                if (next.equals(NN)) {
                    node.right = null;
                } else {
                    TreeNode right = new TreeNode(Integer.parseInt(next));
                    node.right = right;
                    nextQueue.add(right);
                }
                i++;
            }
            queue = nextQueue;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));