class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return check(s, left+1, right) || check(s, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }
    private boolean check(String s, int left, int right) {
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            right--;
            left++;
        }
        return true;
    }
}
