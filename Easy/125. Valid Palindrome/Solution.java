class Solution {
    /*public boolean isPalindrome(String s) {
        s = s.replaceAll("[^0-9a-zA-Z]+", "");
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
    */
    public boolean isPalindrome(String s) {
        //without using regex as that is slower
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            while(start <= end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while(start <= end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if(start<=end && Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
