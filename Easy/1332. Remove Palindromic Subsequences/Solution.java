/*
Notice there are 2 very important information (hints):
1. Remove the subsequence (not substring!). 
2. The input string only consists of letters 'a' and 'b'!
That means, there are 3 situations of this problem:
#1. String length equals 0 -> return 0;
#2. String itself is a Palindrome -> return 1; (because you can remove them all at once)
#3. Other cases, you can first remove all 'a' and then all 'b' or vice versa (first all 'b' then all 'a') -> return 2;
*/
class Solution {
    public int removePalindromeSub(String s) {
        if (s == null || s.length() == 0) {
            return 0; // This is the situation #1.
        }     
        int i = 0;
        int j = s.length() - 1;
        while (i < j) { // Checking the input string whether it is a Palindrome or not, by using the two pointers i and j.
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return 2; // The input string cannot pass the while-loop, so it is not a Palindrome. This is the situation #3.
            }
        }
        return 1; // The input string passes the while-loop, so it is a Palindrome, so we need 1 operation! This is the situation #2.
    }
}
