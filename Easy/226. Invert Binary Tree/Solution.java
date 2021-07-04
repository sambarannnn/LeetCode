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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            TreeNode templeft = curr.left;
            curr.left = curr.right;
            curr.right = templeft;
            
            if(curr.right != null) 
                queue.add(curr.right);
            if(curr.left != null) 
                queue.add(curr.left);
        }
        return root;
    }
    public TreeNode RECURSIVEinvertTree(TreeNode root) {
        if(root == null)
            return null;
        
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
