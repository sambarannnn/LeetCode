class Solution {
    private int[] memo;
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public int climbStairsMEMO(int n) {
        memo = new int[n+1];
        return steps(n);
    }
    private int steps(int n) {
        
        if(n == 0 || n == 1) {
            return 1;
        }
        if(memo[n] != 0)
            return memo[n];
        return memo[n] = steps(n-1) + steps(n-2);
    }
}
