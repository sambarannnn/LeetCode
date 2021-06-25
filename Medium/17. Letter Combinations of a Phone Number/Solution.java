class Solution {
    //https://www.youtube.com/watch?v=imD5XeNaJXA
    /*
        ~ First we have a string array to be used as a map wherein :
            - indexes correspond to digits on a numpad
            - string elements correspond to chars on a numpad
            
        ~ We have a queue of permutations, we initialize it with an empty string
        
        ~ We run a loop until the length of the permutations don't become equal to the no of given digits
        
        ~ for each iteration, 
            - we remove the first permutation from the queue = curr_permutation
            - to determine which index(number) to find permutations with, we use the length of curr_permutation 
                i.e., if curr_permutation's length is 0, we need to access digits[0]//i.e. first digit(since zero indexed)
            - now, for ever character in this, index's mapping, we add it's combination with curr_permutation to the queue
            - for ex : let list : a, b, c
                       thus, curr permutation = "a" (first iteration)
                       let index = 3, thus, mapping = def
                       we add ad, ae, af to back of list
                       now list = b, c, ad, ae, af
                       repeat with b, c
                       go on until the length of the added permutation doesn't become equal to the length of given digits
                       
        
    */
    public List<String> letterCombinations(String digits) {
        
        Queue<String> result = new LinkedList<String>();//to be used as fifo, remove func removes from head of ll, peek function shows head of ll
        if(digits.length() == 0)
            return (List)result;
        
        result.add("");//initialize queue with empty element
        
        
        String[] mapping = new String[] {
                    "0", 
            "1", "abc", "def", 
            "ghi", "jkl", "mno", 
            "pqrs", "tuv", "wxyz"
        };

        while(result.peek().length() != digits.length()) {
            String curr_permutation = result.remove();//gives the first permtation string in ll queue
            int index = Character.getNumericValue(digits.charAt(curr_permutation.length()));
            for(char c : mapping[index].toCharArray()){ //add each char from the given index's string mapping
                    result.add(curr_permutation + c);//adding at last
                }
        }
        
        /*
        for(int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            
            while(result.peek().length() == i) {// while the first string in queue has "i" no of letters
                String curr_permutation = result.remove();//gives the first permtation string in ll queue
                for(char c : mapping[index].toCharArray()){ //add each char from the given index's string mapping
                    result.add(curr_permutation + c);
                }
            }
        }*/
        return (List)result;
    }
}
