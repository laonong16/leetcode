/*
314.	Binary Tree Vertical Order Traversal
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
 

return its vertical order traversal as:

[
  [9],
  [3,15],
  [20],
  [7]
]
 

Given binary tree [3,9,20,4,5,2,7],

    _3_
   /   \
  9    20
 / \   / \
4   5 2   7
 

return its vertical order traversal as:

[
  [4],
  [9],
  [3,5,2],
  [20],
  [7]
]
*/
class Solution {
	public class VNode {
		TreeNode node;
		int  pos;
		public VNode(TreeNode node, int pos) {
			this.pos = pos;
			this.node = node;
		}
		public List<List<Integer>> verticalTraverse(TreeNode root) {
			List<List<Integer>> result = new ArrayList<>();
			if(root == null) {
				return result;
			}
			int min = 0;
			int max = 0;
			VNode vRoot = new VNode(root,0);
			Queue<VNode> que = new LinkedList<>();
			que.offert(vRoot);
			Map<Integer,List<Integer>> map = new HashMap<>();
			while(!que.isEmpty()) {
				int size = que.size();
				for(int i=0; i<size; i++) {
					VNode vnode = que.poll();
					if(!map.containsKey(vnode.pos)) {
						map.put(vnode.pos, new ArrayList<Integer>());
					}
					map.get(vnode.pos).add(vnode.node.val);
					if(vnode.node.left != null) {
						que.add(new VNode(vnode.node.left,pos-1));
						min = Math.min(pos-1, min);
					}
					if(vnode.node.right != null) {
						que.add(new VNode(vnode.node.right,pos+1));
						max - Math.max(max,pos+1);
					}
				}
			}
			for(int i = min; i <= max; i++){
				result.add(map.get(i));
			}
			return result;
		}
	}
}