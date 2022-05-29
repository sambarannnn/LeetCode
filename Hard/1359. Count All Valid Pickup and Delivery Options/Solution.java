class Solution {
    public int countOrders(int n) {
        long mod =(long) 1e9+7;
        long[] dp = new long[501];
        dp[1] = 1;
        dp[2] = 6;
        for (int i = 3; i <= n; ++i) {
            int places = 2 * i - 1;
            int multi = places * (places + 1) / 2;
            dp[i] = (dp[i-1] * multi) % mod;
        }
        
        return (int) dp[n];
    }
}
