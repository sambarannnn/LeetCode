class Solution {
    public boolean isSubsequence(String s, String t) {
        //USE LCS on s and t
        //if length of lsc is equal to length of s
        //then all characters of s are present as a subsequence in t
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[s.length()][t.length()] == s.length();
    }
}
