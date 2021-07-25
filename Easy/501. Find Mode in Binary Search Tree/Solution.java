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
    //we can perform inorder traversal which would traverse it in a sorted ascending manner
    //for ever node, we can check if the curr node's val is equal to last node's value
    //we incremenet curr_count when this happens
    //at any point, if curr, count becomes equal to max count, we add it as an additional mode
    //next, if curr_count becomes greater than max_count, we clear the curr modes, and add this as the only mode
    
    private static TreeNode prev = null;
    private static int curr_count = 0;
    private static int max_count = Integer.MIN_VALUE;
    
    public int[] findMode(TreeNode root) {
        prev = null;
        curr_count = 0;
        max_count = Integer.MIN_VALUE;
        List<Integer> modes = new ArrayList<Integer>();
        
        inorderTraverse(root, modes);
        
        int[] ans = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) 
            ans[i] = modes.get(i);
        return ans;
    }
    
    private void inorderTraverse(TreeNode root, List modes) {
        if(root == null)
            return;
        inorderTraverse(root.left, modes);
        
        //process current node
        if(prev == null || prev.val == root.val) {
            curr_count++;
        } else if(prev.val != root.val){
            curr_count = 1;//reset curr count
        }
        
        if(curr_count == max_count) {
            modes.add(root.val);//add new mode
        } else if(curr_count > max_count) {
            //clear modes and add this as only new mode
            max_count = curr_count;
            modes.clear();
            modes.add(root.val);
        }
        prev = root;
        
        inorderTraverse(root.right, modes);
    }
}
