class Solution {
    public String longestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length()+1][s.length()+1];
        int maxLen = 0;
        int endIndex = 0;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(s.charAt(i-1) == rev.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    //index of first element of current common s2 substring
                    int s2FirstIndex = j - dp[i][j] + 1;
                    //i is pointing at last element of current common s1 substring
                    //i's index in reversed s1, i.e., s2 should be equa to s2FirstIndex for it to be considered in valid palindrome
                    int s1LastEleInRev = s.length() - i + 1;
                    
                    if(s2FirstIndex == s1LastEleInRev) {
                        if(maxLen < dp[i][j]) {
                            endIndex = i;
                            maxLen = dp[i][j];
                        }
                    }
                }
            }
        }
        int startIndex = endIndex - maxLen + 1;
        return s.substring(startIndex-1, endIndex);
    }
}
