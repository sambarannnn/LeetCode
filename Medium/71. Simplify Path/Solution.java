class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");//creates strings exclusing any and all consecutive /
        Stack<String> stack = new Stack<String>();
        
        for(String dir : dirs) {
            if(dir.equals("..") && !stack.isEmpty())
                stack.pop();
            else if(!dir.equals(".") && !dir.equals("..") && !dir.equals(""))//empty string caused by consecutive //
                stack.push(dir);
        }
        
        if(stack.isEmpty())//nothing was pushed into stack
            return "/";
        
        Stack<String> reversed_stack = new Stack<String>();
        while(!stack.isEmpty())
            reversed_stack.push(stack.pop());
        
        //now we have reversed stack, that we can pop to make our canonical path
        StringBuilder res = new StringBuilder();
        while(!reversed_stack.isEmpty())
            res.append("/" + reversed_stack.pop());
        return res.toString();
    }
}
