class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode  node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        // level traverse  until get first null node.
        // after that  check is there is no null node left
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }
}