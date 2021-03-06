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
    class Node {
        TreeNode node;
        int x;
        int y;
        Node(TreeNode node, int x, int y){
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, LinkedHashMap<Integer, List<Integer>>> map = new TreeMap<>();
        Node node = new Node(root, 0, 0);
        Queue<Node> q = new LinkedList<Node>();
        q.offer(node);

        while (!q.isEmpty()){
            Node cur = q.poll();
            LinkedHashMap<Integer, List<Integer>> vertical = map.computeIfAbsent(cur.x, k -> (new LinkedHashMap<>()));
            List<Integer> level = vertical.computeIfAbsent(cur.y, k->(new ArrayList<>()));
            level.add(cur.node.val);

            if (cur.node.left != null){
                q.offer(new Node(cur.node.left, cur.x - 1, cur.y + 1));
            }
            if (cur.node.right != null){
                q.offer(new Node(cur.node.right, cur.x + 1, cur.y + 1));
            }
        }

        List<List<Integer>> ret = new ArrayList<>();
        for (LinkedHashMap<Integer, List<Integer>> vertical : map.values()){
            List<Integer> v = new ArrayList<>();
            for (List<Integer> level : vertical.values()){
                Collections.sort(level);
                v.addAll(level);
            }
            ret.add(v);
        }
        return ret;
    }
}