// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Reorder List
// https://leetcode.com/problems/reorder-list/
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
    public void reorderList(ListNode head) {
     /* 
     //stack +slow and  fast pointer
     if(head == null)
            return;
        ListNode slow = head, fast = head;
        LinkedList<ListNode> stk = new LinkedList<>();
      //Detect the cutting node by slow-fast-runner
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
      //Cut the list, push the second part into stack
        ListNode toInsert = slow.next;
        slow.next = null;
        while(toInsert != null){
            stk.push(toInsert);
            toInsert = toInsert.next;
        }
        slow = head;
        fast = slow.next;
      //Insert nodes of second part into first part at every interval between two nodes.
        while(!stk.isEmpty()){
            slow.next = stk.pop();
            slow.next.next = fast;
            slow = fast;
            fast = slow.next;
        }*/
      //three steps
        
   if (head == null || head.next == null)
          return;
      
      // step 1. cut the list to two halves
      // prev will be the tail of 1st half
      // slow will be the head of 2nd half
      ListNode prev = null, slow = head, fast = head, l1 = head;
      
      while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
      }
      
      prev.next = null;
      
      // step 2. reverse the 2nd half
      ListNode l2 = reverse(slow);
      
      // step 3. merge the two halves
      merge(l1, l2);
    }
    
    ListNode reverse(ListNode head) {
      ListNode prev = null, curr = head, next = null;
      
      while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      
      return prev;
    }
    
    void merge(ListNode l1, ListNode l2) {
      while (l1 != null) {
        ListNode n1 = l1.next, n2 = l2.next;
        l1.next = l2;
        
        if (n1 == null)
          break;
            
        l2.next = n1;
        l1 = n1;
        l2 = n2;
      }
    }
}
