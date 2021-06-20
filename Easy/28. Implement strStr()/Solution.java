class Solution {
    public int strStr(String haystack, String needle) {
        int haystack_length = haystack.length();
        int needle_length = needle.length();
        
        if(needle_length == 0)
            return 0;
        if(needle_length > haystack_length)
            return -1;
        
        for(int i = 0; i <= haystack_length - needle_length; i++) {
            if(haystack.substring(i, i+needle_length).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
