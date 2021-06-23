class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        //O(NlogN)
        //we can sort the strings, so after sorting we should have the same letters
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);

        /*O(N)
        //create a sort of hashmap for all 26 letters
        //increment values for letters in s, decremenet values for ltters in t
        //at the end all letters must have zero values for it to be considered an anagram
        int[] hm = new int[26];
        //defaults to all zero values
        for(int i = 0; i < s.length(); i++) {
            hm[s.charAt(i) - 'a']++;
            hm[t.charAt(i) - 'a']--;
        }
        //now lets check the map
        for(int i = 0; i < 26; i++) {
            if(hm[i] != 0)
                return false;
        }
        return true;
        */
    }    
}
