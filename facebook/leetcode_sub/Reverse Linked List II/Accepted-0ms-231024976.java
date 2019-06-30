// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Reverse Linked List II
// https://leetcode.com/problems/reverse-linked-list-ii/
// 

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
        if(head == null || m >= n) {
            return head;
        }
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode preMNode = dummy;
        for (int i = 1; i < m; i++) {
            if (preMNode == null) {
                return null;
            }
            preMNode = preMNode.next;
        }
        ListNode  mNode = preMNode.next;
        ListNode nNode = mNode;
        ListNode postNNode = mNode.next;
        for (int i = m; i < n; i++) {
            if (postNNode == null) {
                return null;
            }
            ListNode temp = postNNode.next;
            postNNode.next = nNode;
            nNode = postNNode;
            postNNode = temp;
        }
         mNode.next = postNNode;
        preMNode.next = nNode;
        return dummy.next;
    }
}

