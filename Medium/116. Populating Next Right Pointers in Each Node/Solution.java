/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //using O(1) space and O(N) time
        Node level = root;
        
        //traverse each level(move to left child in each iteration)
        //mark next pointers and use them itself to traverse horizontally(levelwise)
        while(level != null) {
            
            Node curr = level;
            
            while(curr != null) {
                
                if(curr.left != null) {
                    curr.left.next = curr.right;
                }
                if(curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
    /*
    public Node connect(Node root) {
        //using O(N) space and O(N) time
        //perform level order traversal
        //make reqd adjustments
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        if(root == null)
            return null;
        while(!queue.isEmpty()) {
            int levelNum = queue.size();
    
            for(int i = 0; i < levelNum; i++) {
                Node curr = queue.remove();
                //last node in each level has to be made null
                if(i == levelNum - 1)
                    curr.next = null;
                else
                    curr.next = queue.peek();
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right!= null)
                    queue.add(curr.right);
            }  
        }
        return root;
    }
    */
}
