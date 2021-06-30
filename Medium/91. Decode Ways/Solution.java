class Solution {
    public int numDecodings(String s) {
        //dp array stores number of ways to decode till this index
        int dp[] = new int[s.length() + 1];
        //no of ways to decode empty string is 1 : empty string itself
        dp[0] = 1;
        //for first char, if it is 0,, no of ways to decode is 0; else no of ways to decode is 1
        if(s.charAt(0) == '0')
            dp[1] = 0;
        else
            dp[1] = 1;
        
        for(int i = 2; i <= s.length(); i++) {
            int onedigit = Integer.valueOf(s.substring(i-1, i));//gives us [i-1]th element
            int twodigit = Integer.valueOf(s.substring(i-2, i));//gives us[i-2][i-1] as an integer
            
            if(onedigit >= 1) {//there exists a mapping
                dp[i] += dp[i-1];
            }
            if(twodigit >= 10 && twodigit <= 26) {//two digit no has to be between 10 and 26
                dp[i] += dp[i-2];//adding no of ways to decode till (two digit no's first digit)
            }
        }
        return dp[s.length()];
    }
}
