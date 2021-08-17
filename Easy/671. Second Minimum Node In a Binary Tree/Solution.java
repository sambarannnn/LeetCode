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
    private Integer min = null;
    private Integer min2 = null;
    public int findSecondMinimumValue(TreeNode root) {
        
        //special method 
        if(root == null || (root.left == null && root.right == null))
           return -1;
        
        int left = root.left.val;
        int right = root.right.val;
        
        if (root.left.val == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val) {
            right = findSecondMinimumValue(root.right);
        }
        if(left == -1)
           return right;
        if(right == -1)
           return left;
        return Math.min(left, right);
        //traditional method for any tree
        // find(root);
        // if(min2 == null)
        //     return -1;
        // else
        //     return min2;
    }
    private void find(TreeNode root) {
        if(root == null)
            return;
        
        find(root.left);
        
        //process here
        if(min == null || min > root.val) {
            min2 = min;
            min = root.val;
        } else if((min2 == null || min2 > root.val) && root.val != min) {
            min2 = root.val;
        }
        
        find(root.right);
    }
}
