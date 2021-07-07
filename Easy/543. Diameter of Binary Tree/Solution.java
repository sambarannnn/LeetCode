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
    private int max_diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculate(root);
        return max_diameter;
    }
    private int calculate(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftdia = calculate(root.left);
        int rightdia = calculate(root.right);
        
        max_diameter = Math.max(max_diameter, leftdia+rightdia);
        
        return Math.max(leftdia, rightdia) + 1;
    }
}
