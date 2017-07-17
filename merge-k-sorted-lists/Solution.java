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
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = (ListNode)pq.poll();
            dummy.next = new ListNode(node.val);
            dummy = dummy.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return res.next;
        
    }
}