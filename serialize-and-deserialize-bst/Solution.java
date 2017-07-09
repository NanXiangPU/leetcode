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
        TreeNode dummy = root;
        stack.push(dummy);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sb.append(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] nodes = data.split(" ");
        return helper(nodes, 0, nodes.length - 1);
    }
    
    public TreeNode helper(String[] nodes, int i, int j) {
        if (j < i) {
            return null;
        }
        if (j - i == 0) {
            return new TreeNode(Integer.parseInt(nodes[i]));
        }
        int index = -1;
        int rootVal = Integer.parseInt(nodes[i]);
        for(int p = i + 1; p <= j; ++p) {
            int val = Integer.parseInt(nodes[p]);
            if (val > rootVal) {
                index = p;
                break;
            }
        }
        TreeNode res = new TreeNode(Integer.parseInt(nodes[i]));
        if (index == -1) {
            res.left = helper(nodes, i + 1, j);
            res.right = null;
        } else {
            res.left = helper(nodes, i + 1, index - 1);
            res.right = helper(nodes, index, j);
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));