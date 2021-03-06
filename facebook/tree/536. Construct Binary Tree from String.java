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
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        int firstP = s.indexOf("(");
        if (firstP == -1) {
            return new TreeNode(Integer.parseInt(s));
        }

        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, firstP)));

        int start = firstP;
        int count = 0;
        for(int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') count--;
            if (count == 0) {
                if (start == firstP) {
                    root.left = str2tree(s.substring(start+1, i));
                    start = i+1;
                } else {
                    root.right =str2tree(s.substring(start +1, i));
                }
            }
        }
        return root;
    }
}