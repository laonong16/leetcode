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
    public boolean isBalanced(TreeNode root) {
        if (root  == null) {
            return true;
        }
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(leftH - rightH) <= 1;
    }
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}