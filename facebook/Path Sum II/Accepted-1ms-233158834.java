// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Path Sum II
// https://leetcode.com/problems/path-sum-ii/
// 

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        List<Integer> tmp = new ArrayList<>();
        pathSum(root,sum, tmp, result);

        return result;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<>(tmp));     
        }
        pathSum(root.left, sum, tmp, result);
        pathSum(root.right, sum, tmp, result);
        tmp.remove(tmp.size() - 1);
}
}

