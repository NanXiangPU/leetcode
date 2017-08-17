

public class Solution {
	class Node {
		Node left;
		Node right;
		int val;
		public Node (int val) {
			this.val = val;
		}
	}

	public Node convert(Node node) {
		if (node == null) {
			return node;
		}
		if (node.left != null) {
			Node left = convert(node.left);
			for (; left.right != null; left = left.right);
			left.right = node;
			node.left = left;
		}
		if (node.right != null) {
			Node right = convert(node.right);
			for (; right.left != null; right = right.left);
			right.left = node;
			node.right = right;
		}
		return node;
	}

	public Node getHead(Node node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}

	public void print(Node node) {
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.right;
		}
	}

	public static void main(String[] args) {

		Solution s = new Solution();
        // Let us create the tree shown in above diagram
		Node root = s.new Node(10);
		root.left = s.new Node(12);
		root.right = s.new Node(15);
		root.left.left = s.new Node(25);
		root.left.right = s.new Node(30);
		root.left.right.right = s.new Node(3);
		root.right.left = s.new Node(36);

		

        // Convert to DLL
		Node head = s.convert(root);
		head = s.getHead(head);
		s.print(head);

	}
}