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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);
            current = current.right;
            while(current!= null) {
                stack.push(current);
                current = current.left;
            }
        }
        return result;
//         result.addAll(inorderTraversal(root.left));
//          result.add(root.val);
//         result.addAll(inorderTraversal(root.right));
//         return result;
    }
}