class Solution {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)) 
            return -1;
        // the longer string itself is the longest uncommon subsequence
        else 
            return Math.max(a.length(), b.length());
    }
}
