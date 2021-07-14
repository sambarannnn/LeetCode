class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) 
            return false;
        
        HashMap<Character, Character> smap = new HashMap<>();
        HashMap<Character, Character> tmap = new HashMap<>();
        //for every character, check if this character has already been mapped elsewhere
        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            
            //ideal case, mapping absent in both maps
            if(!smap.containsKey(a) && !tmap.containsKey(b)) {
                smap.put(a, b);
                tmap.put(b, a);
            } else {
                //mapping exists in either or both
                //but either or both's mappings dont match
                if(smap.containsKey(a) && smap.get(a) != b)
                    return false;
                if(tmap.containsKey(b) && tmap.get(b) != a)
                    return false;
            }
        }
        return true;
    }
}
