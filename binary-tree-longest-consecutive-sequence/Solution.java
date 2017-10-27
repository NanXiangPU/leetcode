/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, root.val, 0);
        return max;
    }
    
    public void helper(TreeNode node, int target, int len) {
        if (node == null) {
            return;
        }
        if (node.val == target) {
            len++;
        } else {
            len = 1;
        }
        max = Math.max(len, max);
        helper(node.left, node.val + 1, len);
        helper(node.right, node.val + 1, len);
    }
}