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
    public String tree2str(TreeNode root) {
        
        //slower soln
//         if(root == null)
//             return "";
        
//         String left = tree2str(root.left);
//         String right = tree2str(root.right);
        
//         if(root.left == null && root.right == null)
//             return "" + root.val;
        
//         if(root.right == null)
//             return root.val + "(" + left + ")";
//         else
//             return root.val + "(" + left + ")" + "(" + right + ")";
        
        StringBuilder res = new StringBuilder();
        helper(root, res);
        return res.toString();
    }
    
    private void helper(TreeNode root, StringBuilder res) {
        if(root == null)
            return;
        
        res.append(root.val);
        if(root.left == null && root.right == null)
            return;
        
        if(root.left != null) {
            res.append("(");
            helper(root.left, res);
            res.append(")");
        }
        if(root.right != null) {
            if(root.left == null)
                res.append("()");
            res.append("(");
            helper(root.right, res);
            res.append(")");
        }
    }
}
