/*
297. Serialize and Deserialize Binary Tree
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
*/

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
         if (root == null) {
            return "";
        }
         
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
         
        StringBuffer sb = new StringBuffer();
         
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                sb.append(curr.val + ",");
                queue.offer(curr.left);
                queue.offer(curr.right);
            } else {
                sb.append("#" + ",");
            }
        }
         
        // Remove the trailing #
        String result = sb.toString();
        int j = result.length() - 1;
         
        while (j > 0 && result.charAt(j) == ',' && result.charAt(j) == '#') {
            j -= 2;
        }
         
        result = result.substring(0, j);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       if (data == null || data.length() == 0) {
            return null;
        }
         
        Queue<TreeNode> queue = new LinkedList<>();
        String[] nodes = data.split(",");
         
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int i = 1;
 
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode curr = queue.poll();
            if (nodes[i].equals("#")) {
                curr.left = null;
            } else {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[i]));
                curr.left = leftNode;
                queue.offer(leftNode);
            }
             
            i++;
            if (i >= nodes.length) {
                break;
            }
             
            // right node
            if (nodes[i].equals("#")) {
                curr.right = null;
            } else {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[i]));
                curr.right = rightNode;
                queue.offer(rightNode);
            }
             
            i++;
        }
         
        return root; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));