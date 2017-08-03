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
        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                if(a.val < b.val) {
                    return -1;
                }else if(a.val == b.val) {
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for(ListNode listNode : lists) {
            if(listNode != null) {
                pq.offer(listNode);    
            }
        }
        
        while(!pq.isEmpty()) {
            dummy.next = pq.poll();
            dummy = dummy.next;
            
            if(dummy.next != null) {
                pq.offer(dummy.next);
            }
        }
        
        return head.next;
    }
}