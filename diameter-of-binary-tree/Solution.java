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
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxLength(root);
        return max;
    }
    
    public int maxLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxLength(root.left);
        int maxRight = maxLength(root.right);
        max = Math.max(max, maxLeft + maxRight);
        return Math.max(maxLeft, maxRight) + 1;
    }
}