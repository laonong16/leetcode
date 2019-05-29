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
    public int kthSmallest(TreeNode root, int k) {
        int left = countNodes(root.left);
        if (k <= left) {
            return kthSmallest(root.left, k);
        }
        if (k > left + 1) {
            return  kthSmallest(root.right, k - left - 1);
        }
        return root.val;
    }

    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return countNodes(node.left) + 1 + countNodes(node.right);
    }
}