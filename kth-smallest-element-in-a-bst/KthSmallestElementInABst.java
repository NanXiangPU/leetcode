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
    //binary search recursive
    private int count(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + count(node.left) + count(node.right);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        int countLeft = count(root.left);
        int countRight = count(root.right);
        if(countLeft == k - 1) {
            return root.val;
        }else if(countLeft < k) {
            return kthSmallest(root.right, k - countLeft - 1);
        }else {
            return kthSmallest(root.left, k);
        }
    }

    //dfs recursive
    private static int num;
    private static int count;
    
    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        dfs(node.left);
        count--;
        if(count == 0) {
            num = node.val;
            return;
        }
        dfs(node.right);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return num;
    }

    //dfs iterative
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        
        int count = k;
        while(count != 0) {
            TreeNode node = stack.pop();
            count--;
            if(count == 0) {
                return node.val;
            }
            TreeNode right = node.right;
            while(right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        
        return -1;
    }
}