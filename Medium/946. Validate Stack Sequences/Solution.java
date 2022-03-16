class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < popped.length; i++) {
            while(j < pushed.length && (stack.isEmpty() || stack.peek() != popped[i])) {
                stack.push(pushed[j]);
                j++;
            }
            if(stack.isEmpty() || stack.peek() != popped[i]) {
                return false;
            }
            stack.pop();
        }
        return true;
    }
}
