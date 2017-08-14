/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            } 
        });
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            dummy.next = new ListNode(node.val);
            dummy = dummy.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return head.next;
    }
}