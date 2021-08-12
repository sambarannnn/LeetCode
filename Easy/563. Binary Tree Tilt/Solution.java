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
    int sum = 0;
    public int findTilt(TreeNode root) {
        // inorder(root);
        sum = 0;
        int totalsum = findSum(root);
        return sum;
    }
    private int findSum(TreeNode root) {
        //basically while calculating sum of all nodes, extract the required data
        if(root == null)
            return 0;
        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);
        int tilt = Math.abs(leftSum - rightSum);
        sum+= tilt;
        
        return leftSum + rightSum + root.val;
    }
    private void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        
        //process here
        int left = sum(root.left);
        int right = sum(root.right);
        sum += Math.abs(left - right);
        
        inorder(root.right);
    }
    private int sum(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = sum(root.left);
        int right = sum(root.right);
        
        return left+right+root.val;
    }
}
