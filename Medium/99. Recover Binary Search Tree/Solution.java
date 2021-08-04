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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        //https://www.youtube.com/watch?v=LR3K5XAWV5k
        INORDERtraversal(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void INORDERtraversal(TreeNode root) {
        if(root == null)
            return;
        INORDERtraversal(root.left);
        
        System.out.println(root.val);
        if(prev != null && prev.val > root.val) {
            if(first == null)
                first = prev;
            second = root;
        }
        prev = root;
        INORDERtraversal(root.right);
    }
}
