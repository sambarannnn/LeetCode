class Solution {
    private Integer[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new Integer[text1.length()+1][text2.length()+1];
        return longestCommonSubsequence(text1, text2, text1.length(), text2.length());
    }
    public int longestCommonSubsequence(String text1, String text2, int l1, int l2) {
        
        if(l1 == 0 || l2 == 0) {
            return 0;
        }
        if(memo[l1][l2] != null)
            return memo[l1][l2];
        if(text1.charAt(l1-1) == text2.charAt(l2-1)) {
            return memo[l1][l2] = 1 + longestCommonSubsequence(text1, text2, l1-1, l2-1); 
        } else {
            return memo[l1][l2] = Math.max(longestCommonSubsequence(text1, text2, l1, l2-1) ,
                            longestCommonSubsequence(text1, text2, l1-1, l2)
            );
        }
    }
}
