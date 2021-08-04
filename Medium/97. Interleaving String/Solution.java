class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        return check(s1, s2, s3, 0, 0, 0, new Boolean[s1.length()+1][s2.length()+1]);
    }
    private boolean check(String s1, String s2, String s3, int p1, int p2, int p3, Boolean[][] memo) {
        if(p3 == s3.length() && p1 == s1.length() && p2 == s2.length())//we have used up all the strings
            return memo[p1][p2] = true;
        
        if(memo[p1][p2] != null)
            return memo[p1][p2];
        
        boolean one = false;
        boolean two = false;
        
        if(p1 < s1.length() && s1.charAt(p1) == s3.charAt(p3))
            one = check(s1, s2, s3, p1+1, p2, p3+1, memo);
        
        if(p2 < s2.length() && s2.charAt(p2) == s3.charAt(p3))
            two = check(s1, s2, s3, p1, p2+1, p3+1, memo);
        
        if(one || two)
            return memo[p1][p2] = true;
        else
            return memo[p1][p2] = false;
    }
}
