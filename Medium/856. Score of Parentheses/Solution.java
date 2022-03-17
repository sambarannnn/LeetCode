class Solution {
    public int scoreOfParentheses(String s) {
        //each () has score 1
        //for () () score => 1 + 1 = 2
        //for ( () () ), score => 2 * (1 + 1)
        //for (( ()  ()) () ), score => 2 * ( (2 * (1 + 1)) + 1 )
        //now, we can observe a pattern that we are basically counting 2 * depth of each () 
        //for each (), score => 2*depth of that()
        //thus,
        int depth = 0;
        char prev = '_';
        int score = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                depth++;
            } else {
                depth--;
                if(prev == '(') {//this is a valid ()
                    score += Math.pow(2, depth);
                }
            }
            prev = c;
        }
        return score;
    }
}
