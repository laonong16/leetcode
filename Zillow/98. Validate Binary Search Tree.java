98. Validate Binary Search Tree
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.

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
    public boolean isValidBST(TreeNode root) {
       return validateBST(root, null, null); 
    }
    private boolean validateBST(TreeNode root, Integer low, Integer high) {
    if (root == null) return true;
    if(high!=null&&root.val>=high)
         return false;
    if(low!=null&&root.val<=low)
     return false;
    return validateBST(root.left, low, root.val) && validateBST(root.right, root.val, high);
}
}