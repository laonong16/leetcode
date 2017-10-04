144. Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        // Stack<TreeNode> stack = new Stack<>();
        // while(root != null || !stack.isEmpty()) {
        //     while(root != null) {
        //         list.add(root.val);
        //         stack.push(root);
        //         root = root.left;
        //     }
        //     root = stack.pop();
        //     root = root.right;
        // }
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }
}