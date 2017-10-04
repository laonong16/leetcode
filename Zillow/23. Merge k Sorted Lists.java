23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>( new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        }
        );
        //java 8
         PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((n1,n2) -> n1.val -n2.val);
        for(ListNode node: lists) {
            if(node != null) {
                pq.offer(node);
            }
        }
        ListNode tail = dummy;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;
            node = node.next;
            if(node != null) {
                pq.offer(node);
            }
        }
        return dummy.next;
    }
}