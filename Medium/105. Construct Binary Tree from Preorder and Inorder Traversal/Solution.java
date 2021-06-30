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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = create(0, 0, inorder.length - 1, preorder, inorder);
        return root;
    }
    
    private TreeNode create(int preorder_index, int inorder_startindex, int inorder_endindex, int[] preorder, int[] inorder) {
        
        if(preorder_index > preorder.length -1 || inorder_startindex > inorder_endindex)
            return null;
        
        int inorder_index;
        for(inorder_index = inorder_startindex; inorder_index <= inorder_endindex; inorder_index++) {
            if(preorder[preorder_index] == inorder[inorder_index])
                break;
        }
        //now we have correct inorder index value
        TreeNode root = new TreeNode(preorder[preorder_index]);
        //for first half of inorder array
        root.left = create(preorder_index + 1, inorder_startindex, inorder_index - 1, preorder, inorder);
        //for 2nd half of inorder array
        root.right = create(preorder_index + (inorder_index - inorder_startindex) + 1, inorder_index + 1, inorder_endindex, preorder, inorder);
        
        return root;
    }
}
