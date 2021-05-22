// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Construct String from Binary Tree
// https://leetcode.com/problems/construct-string-from-binary-tree/
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
    public String tree2str(TreeNode t) {
        if (t == null) {
        return "";
    }
    String res = String.valueOf(t.val);
    String left = tree2str(t.left);
    String right = tree2str(t.right);
    if (!right.equals("")) {
        res += "(" + left + ")" + "(" + right + ")";
    }
    else if (!left.equals("")) {
        res += "(" + left + ")";
    }
    return res;
    }
}
