class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        //FIND LCS, then while printing the LCS, add the skipped chars to the string too inorder to include them into the subsequence
        int len1 = str1.length();
        int len2 = str2.length();
        
        int[][] dp = new int[len1+1][len2+1];
        
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        int i = len1;
        int j = len2;
        while(i != 0 && j != 0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                res.append(str1.charAt(i-1));
                i--;
                j--;
            } else if(dp[i][j-1] > dp[i-1][j]){
                res.append(str2.charAt(j-1));//inslude before skipping
                j--;
            } else {
                res.append(str1.charAt(i-1));
                i--;
            }
        }
        //either one (i or j) is at 0
        while(i != 0) {
            res.append(str1.charAt(i-1));
            i--;
        }
        while(j != 0) {
            res.append(str2.charAt(j-1));
            j--;
        }
        return res.reverse().toString();
    }
}
