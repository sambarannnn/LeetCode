class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> dictionary = new HashMap<Character, Integer>();
        for(int i = 0; i < magazine.length(); i++) {
            dictionary.put(magazine.charAt(i), dictionary.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            //if this char is not present in dictionary or has already been used up
            if(!dictionary.containsKey(c) || dictionary.get(c) == 0)
                return false;
            dictionary.put(c, dictionary.get(c) - 1);
        }
        return true;
    }
}
