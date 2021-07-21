class Solution {
    public boolean isSubsequence(String s, String t) {
        int si;//s index
        int ti = 0;//t index
        for(si = 0; si < s.length(); si++, ti++) {//iterate over s
            char sc = s.charAt(si);
            //check if sc is available in t
            while(ti < t.length() && t.charAt(ti) != sc)
                ti++;//incrementing until either we find sc in t or we go out of bounds
            if(ti >= t.length())
                return false;//if we have gone out of bounds, then this sc is not present in t hence, s is not a subsequence of t
            // if(t.charAt(ti) == sc)
                // ti++;//if we find sc then move ti ahead, si will automatically be moved ahead by for loop
        }
        return true;
    }
}
