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
    public List<Integer> ITRpreorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return res;
    }
    
    public List<Integer> INTUITIVEpreorderTraversal(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		if(root == null) 
            return res;
		Stack<TreeNode> tovisit = new Stack<TreeNode>();
		tovisit.push(root);
		while(!tovisit.empty()) {
			TreeNode visiting = tovisit.pop();
			res.add(visiting.val);
			if(visiting.right != null) 
                tovisit.push(visiting.right);
			if(visiting.left != null) 
                tovisit.push(visiting.left);
		}
		return res;
	}
    
    //RECURSIVE
	// public List<Integer> preorderTraversal(TreeNode root) {
	// 	List<Integer> res = new LinkedList<Integer>();
	// 	preHelper(root,res);
	// 	return res;
	// }
	// public void preHelper(TreeNode root, List<Integer> res) {
	// 	if(root == null) 
	// return;
	// 	res.add(root.val);
	// 	preHelper(root.left,res);
	// 	preHelper(root.right,res);
	// }
}
