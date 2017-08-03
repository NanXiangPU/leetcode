/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                dummy.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                dummy.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            dummy = dummy.next;
        }
        if (p1 == null) {
            dummy.next = p2;
        }
        if (p2 == null) {
            dummy.next = p1;
        }
        return res.next;
    }
}