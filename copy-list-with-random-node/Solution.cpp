/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
class Solution {

//hashmap
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        if (head == NULL) {
            return NULL;
        }
        unordered_map<RandomListNode*, RandomListNode*> map;
        RandomListNode *node = head;
        while(node != NULL) {
            RandomListNode *tmp = new RandomListNode(node->label);
            map[node] = tmp;
            node = node->next;
        }
        node = head;
        while(node != NULL) {
            map[node]->next = map[node->next];
            map[node]->random = map[node->random];
            node = node->next;
        }
        return map[head];
    }

//in place
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        if (head == NULL) {
            return NULL;
        }
        RandomListNode* node = head;
        while(node != NULL) {
            RandomListNode *next = node->next;
            node->next = new RandomListNode(node->label);
            node->next->next = next;
            node = next;
        }
        
        node = head;
        while (node != NULL) {
            if (node->random != NULL) {
                node->next->random = node->random->next;
            }
            node = node->next->next;
        }
        
        RandomListNode* res = new RandomListNode(0);
        RandomListNode* dummy = res;
        node = head;
        while(node != NULL) {
            dummy->next = node->next;
            dummy = dummy->next;
            node->next = node->next->next;
            node = node->next;
        }
        
        return res->next;
    }
};