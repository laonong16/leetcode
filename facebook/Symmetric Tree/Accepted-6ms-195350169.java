// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Symmetric Tree
// https://leetcode.com/problems/symmetric-tree/
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSymmetric(left, right);
    }
    public boolean isSymmetric(TreeNode left, TreeNode right) {
         if (left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
         if (left.val != right.val) {
            return false;
        }
      return  isSymmetric(left.left,right.right) && isSymmetric(left.right, right.left);
    }

}
