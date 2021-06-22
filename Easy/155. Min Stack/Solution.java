class MinStack {

    /** initialize your data structure here. */
    public class Node {
        int val;
        int min;
        Node next;
        
        //each node will keep track of min element at or below it
        private Node(int val, int min) {
            this.val = val;
            this.min = min;
           this.next = null;
        }
        
        private Node(int val, int min, Node next) {
            this.val = val;
            this.next = next;
            this.min = min;
        }
        
    }
    private Node head = null;
    
    public void push(int val) {
        if(head == null) {
            head = new Node(val, val);
        } else {
            //make a new node, to right of head, make it point at head, update min element until this node
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
