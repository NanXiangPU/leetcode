/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = null;
        ListNode dummy = head;
        while (dummy != null) {
            ListNode next = dummy.next;
            dummy.next = res;
            res = dummy;
            dummy = next;
        }
        return res;
    }
}