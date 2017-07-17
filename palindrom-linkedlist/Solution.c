/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverse(struct ListNode* head);

bool isPalindrome(struct ListNode* head) {
    if (head == NULL || head->next == NULL) {
        return true;
    }
    struct ListNode* dummy = head;
    int size = 0;
    while(dummy) {
        dummy = dummy->next;
        size++;
    }
    dummy = head;
    for (int i = 0; i < (size - 1) / 2; ++i) {
        dummy = dummy->next;
    }
    struct ListNode* mid = dummy->next;
    dummy->next = NULL;
    mid = reverse(mid);
    dummy = head;
    while(mid) {
        if (mid->val != dummy->val) {
            return false;
        }
        mid = mid->next;
        dummy = dummy->next;
    }
    return true;
}

struct ListNode* reverse(struct ListNode* head) {
    struct ListNode* res = NULL;
    struct ListNode* dummy = head;
    while(dummy) {
        struct ListNode* next = dummy->next;
        dummy->next = res;
        res = dummy;
        dummy = next;
    }
    return res;
}