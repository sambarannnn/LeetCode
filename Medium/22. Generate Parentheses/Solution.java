class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    public void backtrack(List<String> result, String current_string,int open, int close, int max) {
        if(current_string.length() == max*2) {
            result.add(current_string);
            return;
        }
        
        if(open < max) {
            backtrack(result, current_string + "(", open+1, close, max);
        }
        if(close < open) {
            backtrack(result, current_string + ")", open, close+1, max);
        }
    }
}
