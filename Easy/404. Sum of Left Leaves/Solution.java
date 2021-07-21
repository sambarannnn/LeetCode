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
    public int sumOfLeftLeaves(TreeNode root) {
        
        if(root == null)
            return 0;
        
        int sumAtThisNode = 0;
        
        if(root.left != null) {//if it has a left node, check if left node is a leaf node, if it is a leaf node, then aadd it's value to current sum
            
            if(root.left.left == null && root.left.right == null)
                sumAtThisNode += root.left.val;//adding left leave node's val
        }
        //sum of left leaves from left subtree
        sumAtThisNode += sumOfLeftLeaves(root.left);
        
        //now find left leaves from right subtree
        sumAtThisNode += sumOfLeftLeaves(root.right);
        
        return sumAtThisNode;
    }
}
