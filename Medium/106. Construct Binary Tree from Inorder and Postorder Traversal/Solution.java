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
    private int index = -1;
    HashMap<Integer, Integer> inorder_mapping = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.index = postorder.length-1;
        // we can write a linear search function or we can create a hashmap of the inorder elements and their indices to access them by
        
        int in = 0;
        for(int i : inorder) {
            inorder_mapping.put(i, in++);
        }
        return build(inorder, postorder, 0, inorder.length-1);
    }
    
    private int search(int[] inorder, int start, int end, int val) {
        for(int i = start; i <= end; i++) {
            if(inorder[i] == val)
                return i;
        }
        return -1;
    }
    
    private TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if(start > end) {
            return null;
        }
        int val = postorder[index--];
        TreeNode root = new TreeNode(val);
        
        // int curr = search(inorder, start, end, val);
        int curr = inorder_mapping.get(val);
        //first build right subtree as we are going from last index of postorder--
        root.right = build(inorder, postorder, curr+1, end);
        root.left = build(inorder, postorder, start, curr-1);
        
        return root;
    }
}
