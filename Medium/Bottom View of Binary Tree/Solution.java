class TreeNode {
    int pos;
    Node node;
    TreeNode(int pos, Node node) {
        this.pos = pos;
        this.node = node;
    }
}
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        //TreeMap holds keys in sorted order
        TreeMap<Integer, Integer> nodeVal_to_pos = new TreeMap<Integer, Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(new TreeNode(0, root));
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                int pos = curr.pos;
                nodeVal_to_pos.put(pos, curr.node.data);
                if(curr.node.left != null) {
                    queue.add(new TreeNode(pos-1, curr.node.left));
                } 
                if(curr.node.right != null){
                    queue.add(new TreeNode(pos+1, curr.node.right));
                }
            }
        }
        ArrayList<Integer> bottomView = new ArrayList<Integer>(nodeVal_to_pos.values());
        return bottomView;
    }
}
