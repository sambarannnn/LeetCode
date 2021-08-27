class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = (int) s1.charAt(i-1) + dp[i-1][j-1];//adding ascii value of the chars in lcs
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int lcsAsciiSum = dp[len1][len2];
        int s1AsciiSum = 0, s2AsciiSum = 0;
        for(char c : s1.toCharArray()) {
            s1AsciiSum += (int) c;
        }
        for(char c : s2.toCharArray()) {
            s2AsciiSum += (int) c;
        }
        int res = (s1AsciiSum - lcsAsciiSum) + (s2AsciiSum - lcsAsciiSum);
        return res;
    }
}
