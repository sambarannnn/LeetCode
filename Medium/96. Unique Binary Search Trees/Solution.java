class Solution {
    public int numTrees(int n) {
        
        //lets say n is 4,
        //first we can pick 1 as a root : 1 combination on left(NO VALUE: EMPTY LEFT SUBTREE), and 3 on right(1ROOT -> 2,3,4(RIGHT SUBTREE)) : TOTAL COMB FROM THIS ROOT : 1*3
        //then we can pick 2 as a root : 1 combination in left subtree(just 1) and 3,4 on right so 2 combinations for right subtree : TOTAL COMB : 1*2
        //then we can pick 3 as a root : 2 combination in left subtree(1,2) and 4 on right so 1 combination1 for right subtree : TOTAL COMB : 2*1
        //then we can pick 4 as a root : 3 combination in left subtree(1,2,3) and NOTHING on right so 1 combinations for empty right subtree : TOTAL COMB : 3*1
        //TOTAL COMBINATIONS UPTO N(4) : 1*3 + 1*2 + 2*1 + 3*1
        //N(4) : f(O),f(3) + f(1),f(2) + f(2),f(1) + f(3),f(1) based on number of nodes
        // summation from 0 to n-1 {f(k) + f(n-k-1)}
        //SO, FOR EMPTY SUBTREE, WE GIVE IT ONE COMBINATION
        //FOR 1 NODE, WE GIVE IT ONE COMBINATION
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            //LET'S CALCULATE TOTAL COMBINATIONS UPTO i : dp[i]
            //picking each number as a root from 1 to i
            //left subtree starts from 0 for(taking 1 as first root)
            // FORMULA :summation from 0 to n-1 {f(k) + f(n-k-1)}
            for(int j = 0; j <= i-1; j++) {
                //left subtree permutations * right subtree permutations
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
}
