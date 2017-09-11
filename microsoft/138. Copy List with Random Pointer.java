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
     Map<RandomListNode,RandomListNode> map = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        RandomListNode copy = map.get(head);
        if(copy == null) {
            copy = new RandomListNode(head.label);
            map.put(head,copy);
            copy.next = copyRandomList(head.next);
            copy.random = copyRandomList(head.random);         
        }
        return copy;
        
        // if( head == null) {
        //     return null;
        // }
        // Map<RandomListNode,RandomListNode> map = new HashMap<>();
        // RandomListNode node = head;
        // while(node != null) {
        //     RandomListNode copy = new RandomListNode(node.label);
        //     map.put(node, copy);
        //     node  = node.next;
        // }
        // node = head;
        // while(node != null) {
        //     if(node.random != null) {
        //         map.get(node).random = map.get(node.random);
        //     }
        //     if(node.next != null) {
        //         map.get(node).next = map.get(node.next);
        //     }
        //     node = node.next;
        // }
        // return map.get(head);
    }
}