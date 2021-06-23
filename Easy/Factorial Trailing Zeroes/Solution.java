class Solution {
    public int trailingZeroes(int n) {
        //https://www.youtube.com/watch?v=fx8rUY_iIms for explanation
        //we need to find the no of 5s that occur in the factorial expansion of the number
        //since 2 < 5, for all values of 5 in a factorial expansion, there exists a 2
        //thus, finding number of 5s will give us the reqd no of (2x5) pairs which contribute to the trailing zeroes
        //since we have the formula to calculate prime no occurences in a factorial, we calculate occurences of 5 instead of occurences of 10
        int ans = 0;
        int exp5 = 5;//first power of 5 is 1
        //following code is based on a formula to calculate no. of occorunces of a prime number(5) in the factorial of a number(n)
        while(n/exp5 > 0) {
            ans += n/exp5;
            exp5 *= 5;//increase power of 5
        }
        return ans;
    }
}

