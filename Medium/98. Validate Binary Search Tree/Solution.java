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
    public boolean isValidBST(TreeNode root) {
        //return recursivecheck(root, Long.MIN_VALUE, Long.MAX_VALUE);
        if (root == null) 
            return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //before moving tonext node in inorder traversal, check if previous node is bigger than curr node
            //System.out.println(root.val);//inorder printing
             if(prev != null && root.val <= prev.val)
                 return false;
             prev = root;
            root = root.right;
        }
        return true;
    }
    public boolean recursivecheck(TreeNode root, long min, long max) {
    //for left childs, min value is long.min, max value is parent of that node
    //for right childs, min value is parent of that node, max value is long.max
        if(root == null)
            return true;
        
        if(root.val <= min || root.val >= max)
            return false;
        
        return recursivecheck(root.left, min, root.val) && recursivecheck(root.right, root.val, max);
    }
}
/*
public class Solution {
    //inorder traversal stored in list, then we check if traversal yields sorted result
    List<Integer> inorder = new ArrayList<Integer>();
    
    public boolean isValidBST(TreeNode root) {
        InOrder(root);
        
        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i) >= inorder.get(i+1))
                return false;
        }
        
        return true;
    }
    
    void InOrder(TreeNode node) {
        if (node == null) 
            return;
        
        InOrder(node.left);
        inorder.add(node.val);
        InOrder(node.right);
    }
}
*/
