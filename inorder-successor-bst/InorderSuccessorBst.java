public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = root;
        List<TreeNode> inorderList = new ArrayList<>();
        
        while (dummy != null) {
            stack.push(dummy);
            dummy = dummy.left;
        }
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            inorderList.add(node);
            if (node.right != null) {
                TreeNode tmp = node.right;
                stack.push(tmp);
                while (tmp.left != null) {
                    stack.push(tmp.left);
                    tmp = tmp.left;
                }
            }
        }
        
        TreeNode res = null;
        for (int i = 0; i < inorderList.size(); ++i) {
            TreeNode node = inorderList.get(i);
            if (i < inorderList.size() - 1 && node.equals(p)) {
                res = inorderList.get(i + 1);
            }
        }
        
        return res;
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left != null ? left : root;
        }
    }
}