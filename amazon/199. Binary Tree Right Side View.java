/*
199. Binary Tree Right Side View

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if(i == 0) {
                    result.add(node.val);
                }
                if(node.right != null) {
                    que.offer(node.right);
                }
                if(node.left != null) {
                    que.offer(node.left);
                }
            }
        }
        return result;
    }
}