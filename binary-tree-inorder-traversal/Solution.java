/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = root;
        while (dummy != null) {
            stack.push(dummy);
            dummy = dummy.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                dummy = node.right;
                while (dummy != null) {
                    stack.push(dummy);
                    dummy = dummy.left;
                }
            }
        }
        return list;
    }
}