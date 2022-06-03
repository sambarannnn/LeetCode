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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> zigzaglevelorder = new ArrayList<List<Integer>>();
        queue.add(root);
        if(root == null) 
            return zigzaglevelorder;
        
        boolean zigzag = true;
        
        while(!queue.isEmpty()) {
            int levelNum = queue.size();
            Deque<Integer> current = new ArrayDeque<Integer>();
            for(int i = 0; i < levelNum; i++) {//traversing all nodes in this level
                TreeNode curr = queue.remove();
                
                if(zigzag)//add at last 
                    current.addLast(curr.val);
                else
                    current.addFirst(curr.val);
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            zigzag = !zigzag;//flip zigzag's value so it prints opposite diretion next time
            zigzaglevelorder.add(new ArrayList(current));//adding deque as list
        }
        return zigzaglevelorder;
    }
}
