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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                sb.append(node.val + ",");
                stack.push(node.right);
                stack.push(node.left);
            } else {
                sb.append("null,");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strs = data.split(",");
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(strs));
        return helper(queue);
    }
    
    public TreeNode helper(Queue<String> queue) {
        if (queue.size() == 0) {
            return null;
        }
        String str = queue.poll();
        if (str.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = helper(queue);
        node.right = helper(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));