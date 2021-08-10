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
    
    int min = Integer.MAX_VALUE;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        //inorder traversal would give sorted values
        inorder(root);
        return min;
    }
    private void inorder(TreeNode root) {
        if (root == null) 
            return;
        inorder(root.left);
        //process here
        if(prev != null) {
            min = Math.min((root.val - prev.val), min);//since it's sorted, subtract prev from curr or use math..abs
        }
        prev = root;
        inorder(root.right);
    }
}
