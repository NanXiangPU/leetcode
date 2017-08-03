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
        int size = 0;
        ListNode dummy = head;
        while (dummy != null) {
            dummy = dummy.next;
            size++;
        }
        dummy = head;
        for (int i = 0; i < (size - 1)/ 2; ++i) {
            dummy = dummy.next;
        }
        ListNode mid = dummy.next;
        dummy.next = null;
        mid = reverse(mid);
        dummy = head;
        while(mid != null) {
            if (dummy.val != mid.val) {
                return false;
            }
            dummy = dummy.next;
            mid = mid.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode res = null;
        ListNode dummy = head;
        while(dummy != null) {
            ListNode next = dummy.next;
            dummy.next = res;
            res = dummy;
            dummy = next;
        }
        return res;
    }
}