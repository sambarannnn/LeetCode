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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()) {
            TreeNode root1 = queue.remove();
            TreeNode root2 = queue.remove();
            if(root1 == null && root2 == null)
                continue;
            if(root1 == null || root2 == null)
                return false;
            if(root1.val != root2.val)
                return false;
            queue.add(root1.left);
            queue.add(root2.right);
            queue.add(root1.right);
            queue.add(root2.left);
        }
        return true;
        // return RecursiveCheck(root.left, root.right);
    }
    private boolean RecursiveCheck(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        
        return root1.val == root2.val && RecursiveCheck(root1.left, root2.right) && RecursiveCheck(root1.right, root2.left);
    }
}
