/*426. Convert Binary Search Tree to Sorted Doubly Linked List
        Medium

        418

        50

        Favorite

        Share
        Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.

        Let's take the following BST as an example, it may help you understand the problem better:





        We want to transform this BST into a circular doubly linked list. Each node in a doubly linked list has a predecessor and successor. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

        The figure below shows the circular doubly linked list for the BST above. The "head" symbol means the node it points to is the smallest element of the linked list.





        Specifically, we want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. We should return the pointer to the first element of the linked list.

        The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.

*/

// 根据二叉搜索树的中序遍历得到双向链表的节点值，最后构建一个新的双向链表即可。
public class Solution {
    /**
     * @param root: root of a tree
     * @return: head node of a doubly linked list
     */
    public TreeNode treeToDoublyList(TreeNode root) {
        // Write your code here.
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        helper(root, list);

        TreeNode head = list.get(0);
        TreeNode tail = list.get(list.size() - 1);
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void helper(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        helper(node.left, list);
        list.add(node);
        if (list.size() >= 2) {
            int n = list.size();
            TreeNode a = list.get(n - 2);
            TreeNode b = list.get(n - 1);
            a.right = b;
            b.left = a;
        }
        helper(node.right, list);
    }
}


