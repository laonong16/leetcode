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
    public List<Integer> rightSideView(TreeNode root) {
        // edge case:
        List<Integer> res = new ArrayList<>();
        if( root == null ) return res;

        // general case:
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while( q.size() > 0 ){
            int num = q.size();
            for( int i = 0; i < num; i++ ){
                TreeNode temp = q.poll();
                if( i == 0 ) res.add( temp.val );
                if( temp.right != null ) q.offer( temp.right );
                if( temp.left  != null ) q.offer( temp.left );
            }
        }
        return res;
    }
}