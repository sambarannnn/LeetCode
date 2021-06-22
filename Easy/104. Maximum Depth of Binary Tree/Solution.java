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
    public int maxDepth(TreeNode root) {
        //ITERATIVE BFS
        if(root==null) 
            return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;
            
            for(int i = 0; i < levelSize; i++) {
                TreeNode p = queue.poll();
                
                if(p.left != null)
                    queue.add(p.left);
                if(p.right != null)
                    queue.add(p.right);
            }
        }
        return depth;

    }
    
    public int RECURSIVEmaxDepth(TreeNode root) {
        if(root == null) 
            return 0;
        
        int leftheight = maxDepth(root.left);
        int rightheight = maxDepth(root.right);
        
        return Math.max(leftheight, rightheight) + 1; 
    }
}

