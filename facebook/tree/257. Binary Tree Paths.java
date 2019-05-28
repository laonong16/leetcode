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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, result,"");
        return result;
    }

    public void dfs(TreeNode root, List<String> result, String st) {
        if (root == null) {
            return;
        }
        if(st.length() != 0) {
            st +="->";
        }
        st +=root.val;
        if(root.left == null && root.right  == null ) {
            result.add(st);
            return;
        }
        dfs(root.left, result, st);
        dfs(root.right, result,st);
    }
}