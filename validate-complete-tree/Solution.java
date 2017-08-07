import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class Solution {
	public boolean isValid(TreeNode root) {
		if (root == null) {
			return true;
		}
		Deque<TreeNode> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				TreeNode node = queue.poll();
				if (node == null) {
					sb.append("null,");
				} else {
					sb.append(node.val + ",");
					queue.offer(node.left);
					queue.offer(node.right);
				}
			}
		}
		String str = sb.toString();
		String[] values = str.split(",");
		for (int i = 0; i < values.length; ++i) {
			if (values[i].equals("null")) {
				int j = i + 1;
				while (j < values.length) {
					if (!values[j++].equals("null")) {
						return false;
					}
				}
				return true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);

		System.out.println(s.isValid(root));
	}
}