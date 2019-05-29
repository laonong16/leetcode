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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getLeaf(root1, new ArrayList<>());
        List<Integer> list2 = getLeaf(root2, new ArrayList<>());

        return list1.equals(list2);
    }

    private List<Integer> getLeaf(TreeNode root, List<Integer> temp) {
        if(root == null) {
            return temp;
        }
        if(root.left == null && root.right == null) {
            temp.add(root.val);
        }

        getLeaf(root.left, temp);
        getLeaf(root.right, temp);

        return temp;
    }
}