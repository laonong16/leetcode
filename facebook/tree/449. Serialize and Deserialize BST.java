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

        if(root==null)
            return "";
        StringBuilder resultStr = new StringBuilder();
        preOrder(root,resultStr);
        String result = resultStr.toString();
        if(result.charAt(result.length()-1)==',')
            result =result.substring(0,result.length()-1);
        return result;
    }

    public void preOrder(TreeNode root,StringBuilder resultStr){
        if(root==null)
            return;
        resultStr.append(root.val+",");
        preOrder(root.left,resultStr);
        preOrder(root.right,resultStr);
    }

// Decodes your encoded data to tree.

    public TreeNode deserialize(String data) {
        if(data==null || data.trim().equals(""))
            return null;
        String[] dataArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        TreeNode result = root;
        for(int i=1;i<dataArr.length;i++)
            insertIntoBST(root,Integer.parseInt(dataArr[i]));
        return result;
    }

    public TreeNode insertIntoBST(TreeNode root,int val){
        if(root==null)
            root =  new TreeNode(val);
        if(root.val<val)
            root.right = insertIntoBST(root.right,val);
        else if(root.val>val)
            root.left = insertIntoBST(root.left,val);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));