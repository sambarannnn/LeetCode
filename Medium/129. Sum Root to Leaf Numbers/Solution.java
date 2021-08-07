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
    public int sumNumbers(TreeNode root) {
        return dfsSum(root, 0);
    }
    private int dfsSum(TreeNode root, int currSum) {
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null) {
            //add this value to the currSum and return it from here
            return currSum*10 + root.val;
        }
        //find from left and right subtrees
        int leftSum = dfsSum(root.left, currSum*10 + root.val);
        int rightSum = dfsSum(root.right, currSum*10 + root.val);
        
        return leftSum + rightSum;
    }
}
