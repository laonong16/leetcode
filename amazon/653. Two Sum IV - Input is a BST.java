/*
653. Two Sum IV - Input is a BST
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        inOrder(root,values);
        int left = 0, right = values.size() - 1;
        while(left < right) {
            int sum = values.get(left) + values.get(right);
            if(sum == k) {
                return true;
            } else if(sum > k) {
                right --;
            } else {
                left++;
            }
        }
        return false;
    }
    public void  inOrder(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            node = node.right;
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        
    }
}