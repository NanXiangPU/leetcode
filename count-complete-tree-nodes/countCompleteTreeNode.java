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
    //recursive
    public int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int h = height(root);
        return height(root.right) == h - 1 ? (1 << h) + countNodes(root.right) : (1 << (h - 1)) + countNodes(root.left);
    }

    //iterative 1
    public int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int h = height(root);
        int res = 0;
        while(root != null) {
            if(height(root.right) == h - 1) {
                res += 1 << h;
                root = root.right;
            } else {
                res += 1 << (h - 1);
                root = root.left;
            }
            h--;
        }
        return res;
    }

    //iterative 2
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        TreeNode left = root, right = root;
        int h = 0;
        while(right != null) {
            left = left.left;
            right = right.right;
            h++;
        }
        if(left == null) {
            return (1 << h) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}