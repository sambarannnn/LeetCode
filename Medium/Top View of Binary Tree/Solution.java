class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class TreeNode {
    int pos;
    Node node;
    TreeNode(int pos, Node node) {
        this.pos = pos;
        this.node = node;
    }
}
class Solution {
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // add your code
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeMap<Integer, Integer> pos_to_val = new TreeMap<Integer, Integer>();
        queue.add(new TreeNode(0, root));
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                int pos = curr.pos;
                pos_to_val.putIfAbsent(pos, curr.node.data);
                
                if(curr.node.left != null) {
                    queue.add(new TreeNode(pos-1, curr.node.left));
                }
                if(curr.node.right != null) {
                    queue.add(new TreeNode(pos+1, curr.node.right));
                }
            }
        }
        return new ArrayList<Integer>(pos_to_val.values());
    }
}
