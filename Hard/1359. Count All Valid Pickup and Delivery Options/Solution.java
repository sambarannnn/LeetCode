class Solution {
    public int countOrders(int n) {
        int odd = 3;
        int mod = 1_000_000_007;
        long ans = 1;
        for(int i = 2; i <= n; i++) {
            int sum = (odd) * (odd+1) % (mod)/2;
            ans = (ans * sum) % mod;
            odd += 2;
        }
        return (int)ans % mod;
    }
}
