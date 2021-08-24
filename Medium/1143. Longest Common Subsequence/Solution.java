class Solution {
    // private Integer[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        // memo = new Integer[text1.length()+1][text2.length()+1];
        // return longestCommonSubsequence(text1, text2, text1.length(), text2.length());
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    //MEMOIZED
//     public int longestCommonSubsequence(String text1, String text2, int l1, int l2) {
        
//         if(l1 == 0 || l2 == 0) {
//             return 0;
//         }
//         if(memo[l1][l2] != null)
//             return memo[l1][l2];
//         if(text1.charAt(l1-1) == text2.charAt(l2-1)) {
//             return memo[l1][l2] = 1 + longestCommonSubsequence(text1, text2, l1-1, l2-1); 
//         } else {
//             return memo[l1][l2] = Math.max(longestCommonSubsequence(text1, text2, l1, l2-1) ,
//                             longestCommonSubsequence(text1, text2, l1-1, l2)
//             );
//         }
//     }
}
