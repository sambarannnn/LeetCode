class Solution {
    private int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for(int i = 0; i < 2; i++) {
            dp[i] = cost[i];
        }
        for(int i = 2; i < dp.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);//for the next step above it
    }
    public int minCostClimbingStairsMEMO(int[] cost) {
        int n = cost.length;
        memo = new int[n+1];
        return Math.min(minCost(cost, n-1), minCost(cost, n-2));
    }
    private int minCost(int[] cost, int index) {

        if(index == 0 || index == 1) {
            return memo[index] = cost[index];
        }
        if(memo[index] != 0)
            return memo[index];
        return memo[index] = cost[index] + Math.min(minCost(cost, index-1), minCost(cost, index-2));
    }
}
