class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        if(n < 1)
            return 0;
        if(n <= 2)
            return 1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        // Tn = T(n-3) + T(Tn-2) + T(n-1)
        for(int i = 3; i < dp.length; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        return dp[n];
    }
}
