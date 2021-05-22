// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Increasing Order Search Tree
// https://leetcode.com/problems/increasing-order-search-tree/
// 

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
   TreeNode dummy = new TreeNode(0);
    TreeNode node = dummy;
    public TreeNode increasingBST(TreeNode root) {
        if(root==null){
            return root;
        }
        if(root.left!=null){
            increasingBST(root.left);
        }
        node.right = root;
        root.left = null;
        node = node.right;
        if(root.right!=null){
            increasingBST(root.right);
        }
        return dummy.right;
    }
}
