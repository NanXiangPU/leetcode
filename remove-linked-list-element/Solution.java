/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null && head.val == val) {
            pre = head;
            head = head.next;
        }
        ListNode dummy = head;
        while (dummy != null) {
            if (dummy.val == val) {
                pre.next = dummy.next;
                dummy = dummy.next;
                continue;
            }
            pre = dummy;
            dummy = dummy.next;
        }
        return head;
    }
}