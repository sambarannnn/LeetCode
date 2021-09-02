class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int left = 0;
        int right = letters.length-1;
        if(target >= letters[right]) {
            return letters[left];
        }
        
        while(left < right) {
            int mid = left + (right-left)/2;
            if(target < letters[mid]) {
                right = mid;
            } else if(target >= letters[mid]) {
                left = mid + 1;
            }
        }
        return letters[left];
    }
}
