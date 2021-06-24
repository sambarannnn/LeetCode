class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        //for each character, expand to left and right to check if the characters at left and right are equal
        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            int left = i;
            int right = i;
            
            //if we have equal elements on left and/or right it counts as palindromic
            
            //move left pointer to the left side until it becomes unequal to middle : (i)
            while (left >= 0 && s.charAt(left) == c) {
                left--;
            }
            //move right pointer to the right side until it becomes unequal to mid : (i)
            while (right < s.length() && s.charAt(right) == c) {
                right++;
            }
            //now, left and right pointers are different to middle pointer
            
            //now, as long as left and right pointers are pointing at equal chars, move them resp
            while (left >= 0 && right<s.length() &&s.charAt(left)==s.charAt(right)) {
                left--;
                right++;
            }
            
            //at this point, we have found max edges of the palindrome possible from this elemenet as middle : (i)

           // left + 1 and right - 1 are actually the start and end index of the Palindromic string
            //updating start and end values if the length is bigger
            left = left + 1;
            right = right - 1;
            if (end - start < right - left) {
                start = left;
                end = right;
            }
        }

        return s.substring(start, end + 1);
    }
}


