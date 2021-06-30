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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> levelorder = new ArrayList<List<Integer>>();
        queue.add(root);
        if(root == null) 
            return levelorder;
        
        while(!queue.isEmpty()) {
            int levelNum = queue.size();
            
            levelorder.add(new ArrayList());
            for(int i = 0; i < levelNum; i++) {//traversing all nodes in this level
                TreeNode curr = queue.remove();
                levelorder.get(levelorder.size() - 1).add(curr.val);
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
        }
        return levelorder;
    }
}
