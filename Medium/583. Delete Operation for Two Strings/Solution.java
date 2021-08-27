class Solution {
    public int minDistance(String word1, String word2) {
        //find length of longest common subsequence
        int len1 = word1.length();
        int len2 = word2.length();
        
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int lcsLen = dp[len1][len2];
        int res = 0;
        res += (len1 - lcsLen) + (len2 - lcsLen);
        return res;
    }
}
