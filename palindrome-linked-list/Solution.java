/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode part2 = null;
        if (fast != null) {
            part2 = slow.next;
            slow.next = null;
        } else {
            part2 = pre.next;
            pre.next = null;
        }
        ListNode l2 = reverse(part2);
        ListNode dummy = head;
        while (l2 != null) {
            if (l2.val != dummy.val) {
                return false;
            }
            l2 = l2.next;
            dummy = dummy.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode node) {
        ListNode res = null;
        ListNode dummy = node;
        while (dummy != null) {
            ListNode next = dummy.next;
            dummy.next = res;
            res = dummy;
            dummy = next;
        }
        return res;
    }
}