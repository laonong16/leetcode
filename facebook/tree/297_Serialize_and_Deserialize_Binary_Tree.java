/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return "";
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if(node == null) {
                sb.append("null,");
                continue;
            }
            sb.append(node.val).append(",");
            que.offer(node.left);
            que.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        String[] dArr = data.split(",");
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(dArr[0]));
        que.offer(root);
        for (int i = 1; i < dArr.length; i++) {
            TreeNode node = que.poll();
            if (!dArr[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(dArr[i]));
                node.left= left;
                que.offer(left);
            }
            i++;
            if(!dArr[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(dArr[i]));
                node.right =right;
                que.offer(right);
            }
        }
        return  root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));