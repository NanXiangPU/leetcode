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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return max;
    }
    
    public int maxPathDown(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = Math.max(0, maxPathDown(root.left));
        int maxRight = Math.max(0, maxPathDown(root.right));
        max = Math.max(maxLeft + root.val + maxRight, max);
        return Math.max(maxLeft, maxRight) + root.val;
    }
}