/*
138. Copy List with Random Pointer
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
先遍历链表一次，拷贝next节点，并将原节点与拷贝过后的复制节点的映射关系用hashmap保存起来。然后再遍历一次链表，通过读取hashmap的映射关系来更新复制节点的random节点。
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

Map<RandomListNode, RandomListNode> map = new HashMap<>();  
public RandomListNode copyRandomList(RandomListNode head) {  
    if(head == null) return null;  
    RandomListNode copy = map.get(head);  
    if(copy == null) {  
        copy = new RandomListNode(head.label);  
        map.put(head, copy);  
        copy.next = copyRandomList(head.next);  
        copy.random = copyRandomList(head.random);  
    }  
    return copy;  
}  