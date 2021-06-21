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
    private static List<Integer> list = new ArrayList<Integer>();
    public void recursiveInorder(TreeNode root) {
        if(root == null)
            return;
        recursiveInorder(root.left);
        list.add(root.val);
        recursiveInorder(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        /*list.clear();
        recursiveInorder(root);
        return list;*/
        List<Integer> inorder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                inorder.add(p.val);
                p = p.right;
            }
        }
        return inorder;
    }
}
