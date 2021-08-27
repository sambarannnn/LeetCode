class Solution {
    public int minInsertions(String s) {
      //SAME AS MIN DLETIONS TO MAKE A STRING PAINDROME
        String rev = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length()+1][rev.length()+1];
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(s.charAt(i-1) == rev.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return s.length() - dp[s.length()][rev.length()];
    }
}
