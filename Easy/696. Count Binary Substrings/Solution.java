class Solution {
    public int countBinarySubstrings(String s) {
        int prevLen = 0;
        int currLen = 0;
        int count = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 || s.charAt(i) == s.charAt(i-1))
                currLen++;
            else{
                prevLen = currLen;
                currLen = 1;
            }
            if(prevLen >= currLen)
                count++;
        }
        return count;
    }
}
