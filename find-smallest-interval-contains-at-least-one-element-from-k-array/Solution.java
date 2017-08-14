import java.util.*;

class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}

public class Solution {
	public int[] find(ListNode[] lists) {
		int[] res = {-1,-1};
		if (lists == null || lists.length == 0) {
			return res;
		}
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			public int compare(ListNode a, ListNode b) {
				return a.val - b.val;
			}
		});
		int distance = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (ListNode node : lists) {
			if (node == null) {
				return res;
			}
			pq.offer(node);
			max = Math.max(node.val, max);
		}
		
		while (!pq.isEmpty()) {
			ListNode node = pq.poll();
			min = node.val;
			if (max - min < distance) {
				res[0] = min;
				res[1] = max;
				distance = res[1] - res[0];
			}
			if (node.next != null) {
				max = Math.max(node.next.val, max);
				pq.offer(node.next);
			} else {
				return res;
			}
		}
		return res;
	}
}