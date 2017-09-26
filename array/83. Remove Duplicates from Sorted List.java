/*83. Remove Duplicates from Sorted List
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
     public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = head;
        ListNode cur = head.next;
        while(prev != null && cur != null) {
            if(prev.val == cur.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    // recursion
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(head.val + 1); //dummy value can not be same as first val
        dummy.next = head;
        helper(dummy,head);
        return dummy.next;
    }
    public void helper(ListNode prev, ListNode cur) {
        if(prev == null || cur == null) {
            return;
        }
        if(prev.val == cur.val) {
            prev.next = cur.next;
        }else {
            prev = cur;
        }
        cur = cur.next;
        helper(prev,cur);
    }
}