import java.util.*;

class Node {
	int val;
	Node left;
	Node right;
	public Node(int val) {
		this.val = val;
	}
	public Node(int val, Node left, Node right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Solution {
	public Node copy(Node root) {
		if (root == null) {
			return null;
		}
		Node left = copy(root.left);
		Node right = copy(root.right);
		return new Node(root.val, left, right);
	}

	public String printTree(Node root) {
		StringBuilder sb = new StringBuilder();
		Deque<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				Node node = queue.poll();
				if (node == null) {
					sb.append("null,");
				} else {
					sb.append(node.val + ",");
					queue.offer(node.left);
					queue.offer(node.right);
				}
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	public String serialize(Node root) {
		StringBuilder sb = new StringBuilder();
		serializeHelper(root, sb);
		return sb.toString();
	}

	public void serializeHelper(Node root, StringBuilder sb) {
		if (root == null) {
			sb.append("null,");
		} else {
			sb.append(root.val + ",");
			serializeHelper(root.left, sb);
			serializeHelper(root.right, sb);
		}
	}

	public Node constructTree(String str) {
		Deque<String> queue = new LinkedList<>();
		String[] nodes = str.split(",");
		queue.addAll(Arrays.asList(nodes));
		return helper(queue);
	}

	public Node helper(Queue<String> queue) {
		String str = queue.poll();
		if (str.equals("null")) {
			return null;
		}
		Node node = new Node(Integer.parseInt(str));
		node.left = helper(queue);
		node.right = helper(queue);
		return node;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(6);

		String str = s.printTree(root);

		String serialized = s.serialize(root);
		System.out.println(serialized);

		Node newTree = s.constructTree(serialized);
		s.printTree(newTree);
	}
}