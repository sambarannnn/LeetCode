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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> res = new ArrayList<Double>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0;
            for(int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                levelSum += curr.val;
                
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            double currAvg = levelSum / (double)levelSize;
            res.add(currAvg);
        }
        return res;
    }
}
