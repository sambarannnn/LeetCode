class Solution {
    public int countPrimes(int n) {
        if(n < 3)
            return 0;
        //Sieve of Eratosthenes algorithm modification
        boolean[] non_prime = new boolean[n+1];
        non_prime[0] = true;
        non_prime[1] = true;
        //all are set to false
        for(int i = 2; i*i <= n; i++) {
            //if this number is prime, turn all it's multiples to non prime
            if(non_prime[i] == false) {
                for(int j = i; j*i <= n; j++) {
                    non_prime[i*j] = true;
                }
            }
        }
        //find all false non primes i.e., primes and turn them into 
        int primecount = 0;
        for(int i = 0; i < n; i++) {
            if(non_prime[i] == false)
                primecount++;
        }
        return primecount;
    }
}
