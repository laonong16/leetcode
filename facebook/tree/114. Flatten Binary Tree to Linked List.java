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
    // We have to define a separete field to record which is our last vist node
    public TreeNode lastvisit = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode savedRight = root.right;  // have to save right, since right is going to be changed.
        if (lastvisit != null){
            lastvisit.left = null;
            lastvisit.right = root;
        }
        lastvisit = root;
        flatten(root.left);
        flatten(savedRight);
    }
}


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
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()){
            TreeNode curr = stk.pop();
            if (curr.right!=null)
                stk.push(curr.right);
            if (curr.left!=null)
                stk.push(curr.left);
            if (!stk.isEmpty())
                curr.right = stk.peek();
            curr.left = null;  // dont forget this!!
        }
    }
}