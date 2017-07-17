/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        if (m == 1) {
            ListNode firstPart = head;
            ListNode secondPart = null;
            ListNode dummy = head;
            
            int count = 1;
            while (count < n) {
                dummy = dummy.next;
                count++;
            }
            secondPart = dummy.next;
            dummy.next = null;
            
            firstPart = reverse(firstPart);
            dummy = firstPart;
            while (dummy.next != null) {
                dummy = dummy.next;
            }
            dummy.next = secondPart;
            return firstPart;
        }
        ListNode firstPart = head;
        ListNode firstPartTail = null;
        ListNode secondPart = null;
        ListNode thirdPart = null;
        ListNode dummy = head;
        int count = 1;
        
        while (count < n) {
            dummy = dummy.next;
            count++;
        }
        thirdPart = dummy.next;
        dummy.next = null;
    
        count = 1;
        dummy = head;
        while (count < m - 1) {
            dummy = dummy.next;
            count++;
        }
        firstPartTail = dummy;
        secondPart = dummy.next;
        dummy.next = null;
        
        secondPart = reverse(secondPart);
        firstPartTail.next = secondPart;
        
        dummy = secondPart;
        while (dummy.next != null) {
            dummy = dummy.next;
        }
        dummy.next = thirdPart;
        
        return firstPart;
    }
    
    public ListNode reverse(ListNode node) {
        ListNode res = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = res;
            res = node;
            node = next;
        }
        return res;
    }
}