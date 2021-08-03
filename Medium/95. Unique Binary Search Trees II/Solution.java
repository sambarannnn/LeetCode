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
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(start > end) {
            res.add(null);
            return res;
        } else {
            for(int i = start; i <= end; i++) {
                List<TreeNode> leftSubtreeNodes = generate(start, i-1);
                List<TreeNode> rightSubtreeNodes = generate(i+1, end);
                
                for(TreeNode leftNode : leftSubtreeNodes) {
                    for(TreeNode rightNode : rightSubtreeNodes) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }
}
