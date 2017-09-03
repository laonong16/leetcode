/*
111. Minimum Depth of Binary Tree
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
    public int minDepth(TreeNode root) {
        int depth = 0;
        if(root == null) {
            return depth;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();
            boolean changed = false;
            for(int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if(!changed) {
                    changed = true;
                    depth++;
                }
                if(node.left == null && node.right == null) {
                    return depth;
                } else {
                    if(node.left != null){
                        que.offer(node.left);
                    }
                    if(node.right!= null) {
                        que.offer(node.right);
                    }
                }
            }    
        }
        return depth;
    }
}