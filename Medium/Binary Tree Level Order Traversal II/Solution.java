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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null)
            return res;
        Queue<TreeNode> level = new LinkedList<TreeNode>();
        level.add(root);
        TreeNode curr = root;
        while(!level.isEmpty()) {
            List<Integer> currLevel = new ArrayList<Integer>();
            int size = level.size();
            while(size-- > 0) {
                curr = level.remove();
                currLevel.add(curr.val);
                if(curr.left != null)
                level.add(curr.left);
                if(curr.right != null)
                level.add(curr.right);
            }
            res.addFirst(new ArrayList<Integer>(currLevel));//adding to head
        }
        return res;
    }
}
