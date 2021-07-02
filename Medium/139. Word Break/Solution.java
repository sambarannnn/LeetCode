class Solution {
    //https://www.youtube.com/watch?v=1U4jQusbeJc
    //DP APPROACH
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> Dict = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];//one extra slot for 0th index to store empty strings value
        //each index holds boolean value for wether we can form substring up to this index using dictionary
        //thus, dp[s.length()] should have the final answer
        //dp[0] signifies empty string""
        //empty string can always be formed
        dp[0] = true;
        
        for(int i = 1; i < s.length() + 1; i++) {//i -> right side of string
            for(int j = i - 1; j >= 0; j--) {//j -> left side of string
                if(dp[j] == true && Dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;//if it's possible to make from this point, no need to check further behind
                }
            }
        }
        return dp[s.length()];
    }
    
    /*
    //using a hashmap for memoization
    //the hashmap stores every string which is checked, its true or false value, so we do not have to clculate repeated strings
    //Memoization : O(N^2)
    public boolean wordBreak(String s, List<String> wordDict) {
        return DFSchecker(s, new HashSet<String>(wordDict), new HashMap<String, Boolean>());
    }
    
    private boolean DFSchecker(String s, HashSet<String> Dict, HashMap<String, Boolean> memo) {
        
        if(s.length() == 0)
            return true;
        
        if(memo.containsKey(s))
            return memo.get(s);
        
        for(int i = 0; i < s.length(); i++)  {
            String prefix = s.substring(0, i+1);
            
            if(Dict.contains(prefix)) {
                String tobechecked = s.substring(i+1);
                if(DFSchecker(tobechecked, Dict, memo)) {
                    memo.put(s, true);
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }
    */
    
    /*
    dfs runs too slow O(2^n)
    public boolean wordBreak(String s, List<String> wordDict) {
        return DFSchecker(s, new HashSet<String>(wordDict));
    }
    private boolean DFSchecker(String s, HashSet<String> Dict) {
        
        if(s.length() == 0)
            return true;
        
        for(int i = 0; i < s.length(); i++)  {
            String prefix = s.substring(0, i+1);
            
            if(Dict.contains(prefix)) {
                String tobechecked = s.substring(i+1);
                if(DFSchecker(tobechecked, Dict))
                    return true;
            }
        }
        return false;
    }
    */
}
