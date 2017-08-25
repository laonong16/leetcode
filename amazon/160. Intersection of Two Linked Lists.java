/*
160. Intersection of Two Linked Lists
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode runnerA = headA;
        ListNode runnerB = headB;
        int lenA = 0;
        int lenB = 0;
        while(runnerA != null) {
            lenA++;
            runnerA = runnerA.next;
        }
        while(runnerB != null) {
            lenB++;
            runnerB = runnerB.next;
        }
        runnerA = headA;
        runnerB = headB;
        if(lenA > lenB) {
            int diff = lenA - lenB;
            while(diff != 0) {
                diff--;
                runnerA = runnerA.next;
            }
        }else {
            int diff = lenB - lenA;
            while(diff != 0) {
                diff--;
                runnerB = runnerB.next;
            }   
        }
        while(runnerA != null && runnerB != null && runnerA.val != runnerB.val) {
            runnerA = runnerA.next;
            runnerB = runnerB.next;
        }
        if(runnerA == null || runnerB == null) {
            return null;
        }
        return runnerA;
    }
}