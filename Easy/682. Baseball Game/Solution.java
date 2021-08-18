class Solution {
    public int calPoints(String[] ops) {
        
        Stack<Integer> stack = new Stack();

        for(String op : ops) {
            if (op.equals("+")) {
                int prev = stack.pop();
                int newScore = prev + stack.peek();
                stack.push(prev);
                stack.push(newScore);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for(int i : stack) 
            sum += i;
        return sum;
    }
}
