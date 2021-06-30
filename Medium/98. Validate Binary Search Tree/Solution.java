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
    public boolean isValidBST(TreeNode root) {
        return recursivecheck(root, Long.MIN_VALUE, Long.MAX_VALUE);
        // if (root == null) 
        //     return true;
        // Stack<TreeNode> stack = new Stack<TreeNode>();
        // TreeNode prev = null;
        // while(root != null || !stack.isEmpty()) {
        //     while(root != null) {
        //         stack.push(root);
        //         root = root.left;
        //     }
        //     root = stack.pop();
        //     //System.out.println(root.val);//inorder printing
        //      if(prev != null && root.val <= prev.val)
        //          return false;
        //      prev = root;
        //     root = root.right;
        // }
        // return true;
    }
    public boolean recursivecheck(TreeNode root, long min, long max) {
        if(root == null)
            return true;
        
        if(root.val <= min || root.val >= max)
            return false;
        
        return recursivecheck(root.left, min, root.val) && recursivecheck(root.right, root.val, max);
    }
}
