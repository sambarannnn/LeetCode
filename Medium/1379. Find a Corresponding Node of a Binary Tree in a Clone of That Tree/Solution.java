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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(target == original) {
            return cloned;
        }
        if(original == null) {
            return null;
        }
        TreeNode searchLeft = getTargetCopy(original.left, cloned.left, target);
        if(searchLeft != null) {
            return searchLeft;
        }
        TreeNode searchRight = getTargetCopy(original.right, cloned.right, target);
        return searchRight;
    }
}
