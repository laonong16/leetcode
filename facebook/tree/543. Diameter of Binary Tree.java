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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        int leftHeight = getHeight(root.left) ;
        int rightHeight = getHeight(root.right) ;

        int maxPath = leftHeight + rightHeight;
        int maxPathChild =  Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(maxPath, maxPathChild);
    }
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}