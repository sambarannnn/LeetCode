class Solution {
    public int numSquares(int n) {
        //for any number n, maximum number of perfect squares that can sum to n is n
        //eq for 5, 5 = 1^2 + 1^2 + 1^2 + 1^2 + 1^2
        
        //for all n<=3; least no of perfect square nos that sum to n = n
        //since no other combination available
        //for 1 = 1^2
        //2 = 1^2 + 1^2
        //3 = 1^2 + 1^2 + 1^2
        
        //on the number line, for each number,
        //we can first go left by 1^2
        //then we have to find min no of perfect squares adding up to n - 1^2 and add 1 to it for our first 1^2 splicing
        
        //then go left by 2^2
        //then we have to find min no of perfect squares adding up to n - 2^2 and add 1 for our first 2^2 splicing
        
        //we go left by squares until the squares value is not greater than the number itself
        //for example :
        // possible paths for n = 10
        //splice by 1^2, then find for (10-1^2)8, now 8 can follow same procedure(first splice by 1^2.....then 2^2...)
        //splice by 2^2, then find for (10-2^2)5, now 5 can follow same procedure(first splice by 1^2.....then 2^2...)
        //splice by 3^2, then find for (10-3^2)1, now 1 can follow same procedure(first splice by 1^2.....then 2^2...)
        //at this point we cannot splice by 4^2 as that would be 16 which is > 10
        
        //also we noticed the recursive nature of the problem
        //but this also shows that a recursive implementation would make many calls for the same parameters
        //which can be solved by dp
        
        //lets have a dp of n+1 nos
        int[] dp = new int[n+1];
        //mark first base value
        dp[0] = 0;
        dp[1] = 1;
        //dp[2] = 2;
        //dp[3] = 3;
        
        //we will store the min no of perfect squares that sum to that particular index in that index's space
        for(int i = 2; i <= n; i++) {
            //for every number m, worst case will be m itself
            dp[i] = i;
            //now for each dp, we will increment splicing factor such that it's square doesn't exceed n itself
            for(int splice = 1; splice*splice <= i; splice++) {
                dp[i] = Math.min(dp[i], 1 + dp[i-(splice*splice)]);
            }
        }
        return dp[n];
        
    }
}
