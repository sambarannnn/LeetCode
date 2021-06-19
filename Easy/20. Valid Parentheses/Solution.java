class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0)
            return true;
        if(s.length() == 1)
            return false;
        Stack<Character> stack = new Stack<Character>();
        char[] br = s.toCharArray();
        for(char c : br) {
            //pushing all opening brackets into stack
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.empty())
                    return false;
                //')'='('+1 &'['=']'+2 &'{'='}'+2
                else if(c == stack.peek()+1 || c == stack.peek()+2)
                    stack.pop();
                else
                    return false;
            }
        }
        //after iteration is over, if stack still has elements : not enough closing brackets
        if(stack.empty())
            return true;
        else
            return false;

    }
}
