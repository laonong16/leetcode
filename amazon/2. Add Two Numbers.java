/*
2. Add Two Numbers
ou are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while(l1!= null || l2 != null) {
             int sum = carry;
             if(l1 != null) {
                 sum+=l1.val;
                 l1=l1.next;
             }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            ListNode  temp = new ListNode(sum % 10);
            node.next = temp;
            node = node.next;
        }
        if(carry != 0) {
            ListNode temp = new ListNode(carry);
            node.next = temp;
        }
        return dummy.next;
    }
}