/*Find the Least Common Ancestor  with parent node

given two nodes of a binary tree. The nodes each have a reference to their parent node
 and you do not have the root node of the tree
*/
 
 public class Solution {
 	public  TreeNode getLCA(TreeNode a, TreeNode b) {
 			TreeNode node1 = a;
 			TreeNode node2 = b;
 			while(node1 != node2) {
 				if(node1 == b) {
 					return b;
 				}
 				if(node2 == a) {
 					return a;
 				}
 				if(node1.parent == null && node2.parent == null) {
 					return null;
 				}

 				if(node1.parent != null) {
 					node1 = node1.parent;
 				}
 				if(node2.parent != null) {
 					node2 = node2.parent;
 				}
 			}
 			return node1;
 	}
 	class TreeNode {
 		int val;
 		TreeNode left;
 		TreeNode right;
 		TreeNode parent;
 		public TreeNode( int val) {
 			this.val = val;
 		}
 	}
 }