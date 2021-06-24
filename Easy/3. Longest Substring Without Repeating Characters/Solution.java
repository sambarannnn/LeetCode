class Solution {
    public int lengthOfLongestSubstring(String s) {
        //take two pointers from beginning of string
        //add each element to the set as you traverse
        //if at any point, the set has an equal element, there are two approaches yyou can take
        
        //APPROACH 1 : a hashmap used to store each character value and the index of it's latest(previous) occurence
        //fast pointer(j) is used to traverse string and add elements and update length
        //when we encounter a duplicate element, we move our slow pointer(i) to the next of the prev index (ONLY IF IT IS GREATER THAN CURRENT POSITION OF i)
        //we need to use math.max here to ensure that we don't place i leftwards(since we are not deleting elements from the hashmap, there might be a possibility of sliding leftwards with i, see "abba")
        //O(N) solution
        //char, last index 
        if(s.length() == 0)
            return 0;
        int maxlength = 0;
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while(i < s.length() && j < s.length()) {
            if(map.containsKey(s.charAt(j))) {
                int previndex = map.get(s.charAt(j));//prev index of currrent element
                i = Math.max(i, previndex+1);//ensuring that i doesn't move behind current i i.e., doesnt move leftwards
                }
            maxlength = Math.max(maxlength, j-i+1);
            map.put(s.charAt(j), j);
            j++;
        }
        return maxlength;
        
        //APPROACH 2 :
        //if element is not present in hashset, add it to the hashset and calculate length
        //if curr element is in hashset, then delete elements from front(slow pointer) until you are able to add the current(fast pointer) element
        //slow pointer = i
        //fast pointer = j
        /*
         if(s.length() == 0)
            return 0;
        int maxlength = 0;
        int i = 0;
        int j = 0;
        char[] arr = s.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        while(i < arr.length && j < arr.length) {
            while(set.contains(arr[j])) {
                set.remove(arr[i]);
                i++;
            }
            maxlength = Math.max(maxlength, j-i+1);
            set.add(arr[j]);
            j++;

        }
        return maxlength;
        */

        
    }
}
