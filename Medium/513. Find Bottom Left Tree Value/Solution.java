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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode leftmost = null;
        queue.add(root);
        while(!queue.isEmpty()) {
            int levelNum = queue.size();
            
            for(int i = 0; i < levelNum; i++) {//traversing all nodes in this level
                TreeNode curr = queue.remove();
                if(i == 0) {
                    leftmost = curr;
                }
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
        }
        return leftmost.val;
    }
}
