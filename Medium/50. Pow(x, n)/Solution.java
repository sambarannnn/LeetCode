class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {//(1/x)^n
            n = 0 - (n + 1);//we decrease the power of (1/x) by 1, so later we multiply by (1/x) to handle it
                //this is done to handle n = INTEGER.MIN_VALUE case
            //Integer min = -2147483648
            //turned into -2147483647(by adding 1), then making it positive 2147483647
            //so we need to multiply extra (1/x) to make it 2147483648
            return (1/x) * power(1/x, n);
        }
        return power(x, n);
    }
    
    public double power(double x, int n) {
        if(n == 0)
            return 1;
        if(n % 2 == 0) {//x^n can be broken into x^(n/2) * x^(n/2) for even value of n
            double result = power(x, n/2);
            return result * result;
        } else {
            return x * power(x, n-1);//x^n can be broken into x * x^(n - 1) for odd value of n, now, in next recursive block, (n-1) wallue will give even n, so we can execute the if(n%2==0) block on it.
        }
    }
}
