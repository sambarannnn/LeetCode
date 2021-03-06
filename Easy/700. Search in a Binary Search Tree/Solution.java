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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode p = root;
        while(p != null) {
            if(p.val == val) {
                return p;
            } else if(p.val > val) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }
}

// class Solution {
//     public TreeNode searchBST(TreeNode root, int val) {
//         if(root == null)
//             return null;
//         if(root.val == val)
//             return root;
        
//         if(root.val > val)
//             return searchBST(root.left, val);
//         else //(root.val < val)
//             return searchBST(root.right, val);
//     }
// }
