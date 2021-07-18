/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(p.val < root.val && q.val < root.val)
                root = root.left;
            else if(p.val > root.val && q.val > root.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }
    public TreeNode RECURSIVElowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        
        if(p.val < root.val && q.val < root.val)
            return RECURSIVElowestCommonAncestor(root.left, p, q);
        else if(p.val > root.val && q.val > root.val)
            return RECURSIVElowestCommonAncestor(root.right, p, q);
        else //(p.val <= root.val && root.val <= q.val)
            return root;
    }
}
