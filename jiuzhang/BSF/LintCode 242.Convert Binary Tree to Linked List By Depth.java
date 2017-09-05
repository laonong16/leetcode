/*

LintCode 242 : Convert Binary Tree to Linked List By Depth
Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
 (e.g., if you have a tree with depth D, you’ll have D linked lists).
 Given binary tree:

    1
   / \ 
  2   3 
 / 
4 
return

[ 
1->null, 
2->3->null, 
4->null 
]
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
		public List<ListNode> convertToLinkedList(TreeNode root) {
			List<ListNode> result = new ArrayList<>();
			if(root == null) {
				return result;
			}
			Queue<TreeNode> que = new LinkedList<>();
			que.offer(root);
			while(!que.isEmpty()) {
				int size = que.size();
				ListNode dummy = new ListNode(0);
				ListNode tail = dummy;
				for(int i = 0; i < size; i++) {
					TreeNode node = que.poll();	
					ListNode curNode = new ListNode(node.val);
					tail.next = curNode;
					tail = tail.next;
					if(node.left != null) {
						que.offer(node.left);
					}
					if(node.right != null) {
						que.offer(node.right);
					}
				}
				result.add(dummy.next);
			}
			return result;
		}
}