class BracketPos{
    int index;
    char c;
    BracketPos(char c, int index) {
        this.c = c;
        this.index = index;
    }
}
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder(s);
        Stack<BracketPos> stack = new Stack<BracketPos>();
        // PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
        for(int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            if(c =='(') {
                stack.push(new BracketPos(c, i));
            } else if(c == ')') {
                if(!stack.isEmpty() && stack.peek().c == '(') {
                    stack.pop();
                } else {
                    // minheap.add(i);
                    result.setCharAt(i, '*');
                }
            }
        }
        while(!stack.isEmpty()) {
            // minheap.add(stack.pop().index);
            result.setCharAt(stack.pop().index, '*');
        }
        // int i = 0;
        // while(!minheap.isEmpty()) {
        //     result.deleteCharAt(minheap.remove() - i);
        //     i++;
        // }
        return result.toString().replaceAll("\\*", "");
    }
}
