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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<PositionNode> q = new LinkedList<>();

        q.add( new PositionNode(root,0));

        int min = 0;
        int max = 0;

        while (!q.isEmpty()) {
            PositionNode pNode = q.poll();
            if (map.get(pNode.pos) == null) {
                map.put(pNode.pos, new ArrayList<>());
            }
            map.get(pNode.pos).add(pNode.node.val);

            if (pNode.node.left != null) {
                q.add(new PositionNode(pNode.node.left, pNode.pos - 1));
                min = Math.min(min, pNode.pos - 1);
            }

            if (pNode.node.right != null) {
                q.add(new PositionNode(pNode.node.right, pNode.pos + 1));
                max = Math.max(max, pNode.pos + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }

        return res;
    }
    class PositionNode {
        TreeNode node;
        int pos;
        public PositionNode (TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }
}