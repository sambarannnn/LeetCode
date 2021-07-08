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
    public boolean isBalanced(TreeNode root) {
        
        //we have the function to calculate depth of tree
        //let's call that function with our given root
        //while executing depth function, at any point if we come across an unbalanced node, we return -1
        // if it returns height, then its balanced
        //if it returns -1, then its unbalanced
        int depth = modified_depth(root);
        if(depth == -1)
            return false;
        return true;
        
        
        
//         //here we are finding depth of each left and right subtree for every node that we visit
//         //and checking if we are satisfying given conditions
//         if(root == null)
//             return true;
        
//         int leftsubtree = depth(root.left);
//         int rightsubtree = depth(root.right);
        
//         int difference = Math.abs(leftsubtree - rightsubtree);
        
//         if(difference <= 1) {
//             if(isBalanced(root.left) && isBalanced(root.right))
//                 return true;
//         }
//         return false;
    }
    
    private int modified_depth(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = modified_depth(root.left);
        int right = modified_depth(root.right);
        
        if(left == -1 || right == -1 || Math.abs(left - right) > 1 )
            return -1;
        
        return Math.max(left, right) + 1;
    }
    
    private int depth(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = depth(root.left);
        int right = depth(root.right);
        
        return Math.max(left, right) + 1;
    }
}
