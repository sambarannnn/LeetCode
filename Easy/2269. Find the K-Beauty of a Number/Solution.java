class Solution {
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int res = 0;
        for(int i = 0; i <= s.length()-k; i++) {
            String curr = s.substring(i, i+k);
            int n = Integer.parseInt(curr);
            if(n != 0 && num % n == 0) {
                res++;
            }
        }
        return res;
    }
}
