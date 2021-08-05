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
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length-1);
    }
    
    private int search(int[] inorder, int start, int end, int val) {
        for(int i = start; i <= end; i++) {
            if(inorder[i] == val)
                return i;
        }
        return -1;
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int start, int end) {
        if(start > end) {
            return null;
        }
        int val = preorder[index++];
        int curr = search(inorder, start, end, val);
        TreeNode root = new TreeNode(val);
        root.left = build(preorder, inorder, start, curr-1);
        root.right = build(preorder, inorder, curr+1, end);
        return root;
    }
}
