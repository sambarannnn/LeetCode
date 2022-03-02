class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //EXACTLY LIKE FIND ALL ANAGRAMS
        if(s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int l = 0;
        int r = 0;
        int counter = map.size();
        while(r < s2.length()) {
            if(map.containsKey(s2.charAt(r))) {
                map.put(s2.charAt(r), map.get(s2.charAt(r)) - 1);
                if(map.get(s2.charAt(r)) == 0) {
                    counter--;
                }
            }
            if(counter == 0) {
                return true;
            }
            if(r >= s1.length()-1) {
                if(map.containsKey(s2.charAt(l))) {
                    if(map.get(s2.charAt(l)) == 0) {
                        counter++;
                    }
                    map.put(s2.charAt(l), map.get(s2.charAt(l)) + 1);
                }
                l++;
            }
            r++;
        }
        return false;
    }
}
