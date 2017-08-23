/*
206. Reverse Linked List
Reverse a singly linked list.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        head.next =null;
        ListNode  newHead = reverseList(second);
        second.next = first;
        return newHead;
    }
}