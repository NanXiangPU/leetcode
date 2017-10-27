/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode new_head = dummy;
        dummy.next = head;
        ListNode runner = dummy;
        for (int i = 0; i < n; ++i) {
            runner = runner.next;
        }
        while (runner.next != null) {
            runner = runner.next;
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;
        return new_head.next;
    }
}