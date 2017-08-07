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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(res, "", root);
        return res;
    }
    
    public void helper(List<String> res, String curr, TreeNode root) {
        if (root.left == null && root.right == null) {
            curr += root.val;
            res.add(curr);
            return;
        }
        if (root.left != null) {
            helper(res, curr + root.val + "->", root.left);
        }
        if (root.right != null) {
            helper(res, curr + root.val + "->", root.right);
        }
    }
}