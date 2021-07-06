class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {//for each amount
            for(int coin : coins) {//for each coin
                if(coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);//check if by subtracting this coin value(using this coin), the remaining amount can be achieved using lower number of coins
                }
            }
        }
        if(dp[amount] == amount + 1)
            return -1;
        return dp[amount];
    }
}
