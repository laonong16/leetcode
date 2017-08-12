/*
138. Copy List with Random Pointer
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();  
        RandomListNode dummy = new RandomListNode(0);  
        RandomListNode node = dummy, h = head;  
        while(head != null) {  
            RandomListNode copy = new RandomListNode(head.label);  
            map.put(head, copy);  
            node.next = copy;  
            node = node.next;  
            head = head.next;  
        }  
        node = dummy.next;  
        while(node != null) {  
            if(h.random != null) {  
                node.random = map.get(h.random);      
            }  
            h = h.next;  
            node = node.next;  
        }  

        return dummy.next;  
    }
}