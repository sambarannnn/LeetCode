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
        
        if(root == null)
            return true;
        
        int leftsubtree = depth(root.left);
        int rightsubtree = depth(root.right);
        
        int difference = Math.abs(leftsubtree - rightsubtree);
        
        if(difference <= 1) {
            if(isBalanced(root.left) && isBalanced(root.right))
                return true;
        }
        return false;
    }
    
    private int depth(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = depth(root.left);
        int right = depth(root.right);
        
        return Math.max(left, right) + 1;
    }
}
