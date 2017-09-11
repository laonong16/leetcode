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
        ListNode prev = head;
        ListNode cur = head.next;
        prev.next = null;
        while(cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next =prev;
            prev = temp;
        }
        return prev;
    }
}