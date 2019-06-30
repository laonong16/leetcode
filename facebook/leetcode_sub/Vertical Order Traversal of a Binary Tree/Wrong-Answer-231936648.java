// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Vertical Order Traversal of a Binary Tree
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int cur  = 0;
        Queue<LevelNode> queue = new LinkedList<>();
        queue.offer(new LevelNode(root,0));
        while (!queue.isEmpty()) {
            LevelNode node = queue.poll();
            if (map.get(node.level) == null) {
                map.put(node.level, new ArrayList<>());
            }
            map.get(node.level).add(node.node.val);
            min = Math.min(node.level,min);
            max = Math.max(node.level, max);
            if (node.node.left != null) {
                queue.offer(new LevelNode(node.node.left, node.level - 1));
            }
            if (node.node.right != null) {
                queue.offer(new LevelNode(node.node.right, node.level + 1));
            }
        }
        for (int  i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }
   
}
public  class LevelNode {
        TreeNode node;
        int level;
        public LevelNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

