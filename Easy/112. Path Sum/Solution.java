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
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum);
    }
    
    public boolean helper(TreeNode root, int sum) {
        //if we cross leaf node without finding correct sum(0 value)
        if(root == null)
            return false;
        
        //leaf node, here after subtracting, we must get 0
        if(root.left == null && root.right == null && sum - root.val == 0) 
            return true;
        
        boolean left = helper(root.left, sum - root.val);
        boolean right = helper(root.right, sum - root.val);
        
        if(left || right)
            return true;
        return false;
    }
    
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         if(root == null)
//             return false;
//         return helper(root, 0+root.val, targetSum);
//     }
    
//     private boolean helper(TreeNode root, int sum, int targetSum) {
//         if(root.left == null && root.right == null) {
//             if(sum == targetSum)
//                 return true;
//             return false;
//         }
//         boolean left = false, right = false;
//         if(root.left != null)
//              left = helper(root.left, sum + root.left.val, targetSum);
//         if(root.right != null)
//              right = helper(root.right, sum + root.right.val, targetSum);
        
//         if(left || right)
//             return true;
//         return false;
//     }
}
