/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        //MORRIS TRAVERSAL
        if(root == null)
            return;
        
        while(root != null) {
            //if left subtree exists
            if(root.left != null) {
                TreeNode left = root.left;//left child of root
                TreeNode curr = left;
                while(curr.right != null)
                    curr = curr.right;//find rightmost node of the left child of root
                curr.right = root.right;//connect this to the right child of root
                
                root.right = left;//connect modified left subtree to root's right child, this left is also holding a connection to the original right child, so we can modify here
                root.left = null;//make left null
            }
            root = root.right;
        }
    }
    public void RECURSIVEflatten(TreeNode root) {
        
        if(root == null)
            return;
        //store left subtree
        TreeNode left = root.left;
        //store right subtree
        TreeNode right = root.right;
        //make left null
        root.left = null;
        //flatten left subtree
        flatten(left);
        //flatten right subtree
        flatten(right);
        
        //attach flattened left subtree to right
        root.right = left;
        //traverse to end(rightmost of the attached subtree)
        TreeNode curr = root;
        while(curr.right != null)
            curr = curr.right;
        //attach flattened right subtree here
        curr.right = right;
        
    }
}
