class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        //same as longest common substring
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        int max = 0;
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(dp[i][j], max);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
