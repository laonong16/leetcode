92. Reverse Linked List II
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i = 0; i < m -1; i++){
            prev = prev.next;
        }
        ListNode first = prev.next;
        ListNode second = first.next;
        for(int i = m; i < n && second != null; i++){
            first.next = second.next;
            second.next = prev.next;
            prev.next =  second;
            second = first.next;
        }
       
        return dummy.next;
            
    }
}