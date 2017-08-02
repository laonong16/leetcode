/*
2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Thought:

1, use  dummy node to store the head
2. use  variable to store  carry

O(n)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 ==  null) return l2;
        if(l2 == null) return l1;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail =  dummy;
        while(l1 != null || l2 != null || carry != 0) {
            int val1 = l1 == null? 0:l1.val;
            int val2 = l2 == null? 0 : l2.val;
            int sum = val1+val2+carry;
            carry = sum /10;
            ListNode node = new ListNode(sum % 10);
            tail.next = node;
            tail = tail.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}