class Solution {
    public int fib(int n) {
        // return fib(n, new int[n+1]);
        if (n <= 1) {
		return n;            
	    }
        // initialize base case variables
        int a = 0, b = 1;
        int sum = 0;
        //dp soln
        for(int i = 0; i < n-1; i++) {
            // calculate next value as the sum of previous two values
            sum = a + b;
            // switch all values to the next value in the series
            a = b;
            b = sum;
        }
        return sum;
    }
    // private int fib(int n, int[] memo) {
    //     //recursion with memoization
    //     if(n <= 1)
    //         return n;
    //     if(memo[n] != 0)
    //         return memo[n];
    //     memo[n] = fib(n - 1) + fib(n - 2);
    //     return memo[n];
    // }
}
