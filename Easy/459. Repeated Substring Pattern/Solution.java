class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //max length of the repeating substring can be length/2 , any more than that, if repeated will exceed the total length of string;
        
        int len = s.length();
        //from 1st index to len/2, lets grab each substring and check if this one, if repeated gives us the string that we need
        //only those substrings, whose length can completely divide the total length of the string can be used for our calculations
        //each substring has to be repeated for total_length/substring_length times
        
        for(int i = 0; i < len/2; i++) {
            String sub = s.substring(0, i+1);
            if(s.length() % sub.length() == 0) {//possible to be repeated length-wise
                int num_repeats = s.length() / sub.length();
                //now, lets repeat this string num_repeats number of times 
                StringBuilder res = new StringBuilder();
                for(int j = 0; j < num_repeats; j++) {
                    res.append(sub);
                }
                //now, if res is equal to string, we have found our perfect substring
                if(res.toString().equals(s))
                    return true;
            }
        }
        //if we dont find perfect substring
        return false;
    }
}
