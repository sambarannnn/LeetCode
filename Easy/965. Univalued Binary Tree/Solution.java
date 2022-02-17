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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean left;
        boolean right;
        if(root.left != null) {
            left = root.val == root.left.val;
        } else {
            left = true;
        }
        if(root.right != null) {
            right = root.val == root.right.val;
        } else {
            right = true;
        }
        return (left && right && isUnivalTree(root.left) && isUnivalTree(root.right));
    }
}
