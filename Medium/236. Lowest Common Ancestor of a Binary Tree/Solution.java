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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //while traversing down
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;//this itself is lca
        
        TreeNode leftsearch = lowestCommonAncestor(root.left, p, q);
        TreeNode rightsearch = lowestCommonAncestor(root.right, p, q);
        
        //while traversing bottom to top
        //returning recursive calls
        
        //if we find any one of the nodes at either position, we return that particular found node to it's parent and continue upwards until we find the second one
        
        //if at any point, we have found one at leftsearch and one at right search, we have found the lca
        if(leftsearch != null && rightsearch != null)//found lca here
            return root;
        
        if(leftsearch == null && rightsearch == null)//not here
            return null;
        
        if(leftsearch == null && rightsearch != null)//one of them present at right, so carry this node upwards
            return rightsearch;
        
        else //(leftsearch != null && rightsearch == null)////one of them present at left, so carry this node upwards
            return leftsearch;
    }
}
