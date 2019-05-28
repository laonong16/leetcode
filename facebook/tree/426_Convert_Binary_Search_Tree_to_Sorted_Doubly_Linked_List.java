/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        Node left = treeToDoublyList(root.left);
        Node right = treeToDoublyList(root.right);
        root.left = root;
        root.right = root;
        Node leftConn = connect(left, root);
        return connect(leftConn, right);
    }
    public Node connect(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        Node leftEnd = left.left;
        Node rightEnd = right.left;

        right.left= leftEnd;
        leftEnd.right = right;

        left.left = rightEnd;
        rightEnd.right = left;
        return left;
    }
}