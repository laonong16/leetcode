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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildWithInorderAndPreOrder(0,inorder.length-1,inorder,preorder,0);
    }


    private TreeNode buildWithInorderAndPreOrder(int start,int end,int[] inorder, int[] preorder,int offset){

        if(preorder == null || start > end)
            return null;

        TreeNode node = new TreeNode(preorder[start+offset]);
        int index = getIndex(inorder,preorder[start+offset]);
        node.left = buildWithInorderAndPreOrder(start,index-1,inorder,preorder,offset+1);
        node.right = buildWithInorderAndPreOrder(index+1,end,inorder,preorder,offset);
        return node;
    }

    private int getIndex(int[] nums,int value){
        if(nums == null || nums.length == 0)
            return -1;

        for(int i=0;i<nums.length;i++)
            if(nums[i] == value)
                return i;

        return -1;
    }
}