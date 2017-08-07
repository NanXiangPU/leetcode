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
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 1);
        return max;
    }
    
    public void helper(TreeNode root, int currLen) {
        if (root == null) {
            return;
        }
        max = Math.max(max, currLen);
        if (root.left != null) {
            if (root.val + 1 == root.left.val) {
                helper(root.left, currLen + 1);
            } else {
                helper(root.left, 1);
            }
        }
        if (root.right != null) {
            if (root.val + 1 == root.right.val) {
                helper(root.right, currLen + 1);
            } else {
                helper(root.right, 1);
            }
        } 
    }
}