class MyStack {
    private static Queue<Integer> queue1;
    private static Queue<Integer> queue2;
    private static int top;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    //// push: O(N), pop: O(1) method below using queue1 only
    
    /** Push element x onto stack. */
     public void push(int x) {
         queue1.add(x);
         int n = queue1.size();
         while(n > 1) {
             queue1.add(queue1.remove()); n--;
         }
     }
     /** Removes the element on top of the stack and returns that element. */
     public int pop() {
         return queue1.remove();
     }
    /** Get the top element. */
     public int top() {
         return queue1.peek();
     }
     /** Returns whether the stack is empty. */
     public boolean empty() {
         if(queue1.isEmpty())
             return true;
         return false;
     }
    
//     //push: O(1), pop: O(N) method below
    
//     /** Push element x onto stack. */
//     public void push(int x) {
//         queue1.add(x);
//         top = x;
//     }
//     
//     // /** Removes the element on top of the stack and returns that element. */
//     public int pop() {
//         while(queue1.size() > 1) {
//             top = queue1.remove();
//             queue2.add(top);
//         }
//         //copy queue2 back into queue1
//         while(queue2.size() > 0)
//             queue1.add(queue2.remove());
//         return queue1.remove();
//     }
    
//     /** Get the top element. */
//     public int top() {
//         return top;
//     }
    
//     /** Returns whether the stack is empty. */
//     public boolean empty() {
//         if(queue1.isEmpty() && queue2.isEmpty())
//             return true;
//         return false;
//     }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
