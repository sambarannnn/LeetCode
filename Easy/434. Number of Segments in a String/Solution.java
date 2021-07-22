class Solution {
    public int countSegments(String s) {
        // s = s.trim();
        // if(s.equals(""))
        //     return 0;
        // String[] segments = s.split("\\s+");
        // return segments.length;
        
        
        if(s.equals("") || s.length() == 0)//empty string
            return 0;
        
        int i = 0;
        int count = 0;
        
        for(; i < s.length(); i++) {
            if(s.charAt(i) == ' ')//get rid of leading spaces and all spaces in general
                continue;
            //when we find a non space character
            if(i == 0 || s.charAt(i-1) == ' ' && s.charAt(i) != ' ')//if this index is the starting of a new word or this is the first word
                count++;
        }
        return count;
    }
}
