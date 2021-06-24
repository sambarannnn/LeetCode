class Solution {
    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters[c - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(letters[c - 'a'] == 1)
                return i;
        }
        return -1;
        /*
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
        */
    }
}
