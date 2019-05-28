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
        increasingBST(root.left);
        node.right = root;
        root.left = null;
        node = node.right;
        increasingBST(root.right);
        return dummy.right;
    }
}