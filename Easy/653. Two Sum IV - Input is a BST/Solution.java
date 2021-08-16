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

    private boolean res = false;

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        int target = k;
        res = false;
        inorder(root, target, set);
        return res;
    }
    private void inorder(TreeNode root, int target, HashSet set) {
        
        if(root == null || res == true)//early return if res becomes true
            return;
        inorder(root.left, target, set);
        //process here
        if(set.contains(root.val)) {
            res = true;
        }
            
        set.add(target-root.val);
        inorder(root.right, target, set);
        
    }
}
