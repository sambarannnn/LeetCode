class Solution {
    public int lengthOfLastWord(String s) {
        
        /*
        String[] arr = s.split(" ");
        if(arr.length>0)
            return arr[arr.length-1].length();
        else
            return 0;
        */
        //O(N) SOLUTION
        //lets start from ending
        int count = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) != ' ')
                count++;//counting non whitespace characters
            else { //if we encounter whitespace, i.e., end of last word
                if(count > 0)//making sure that first character from ending isnt a whitespace. i.e. to ignore all trailing whitespaces
                    return count;
            }
        }
        //if string was empty or just contained whitespaces then count has not been incremented after all the iterations. thus at this point count = 0
        return count;
    }
}
