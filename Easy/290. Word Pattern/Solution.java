class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if(str.length != pattern.length())
            return false;
        
        HashMap<Character, String> charToString = new HashMap<Character, String>();
        HashMap<String, Character> stringToChar = new HashMap<String, Character>();
        
        for(int i = 0; i < str.length; i++) {
            
            if(charToString.containsKey(pattern.charAt(i))) {
                if(!str[i].equals(charToString.get(pattern.charAt(i))))
                    return false;
            } else {
                if(stringToChar.containsKey(str[i]))
                    return false;
                stringToChar.put(str[i], pattern.charAt(i));
                charToString.put(pattern.charAt(i), str[i]);
            }
        }
        return true;
    }
}
