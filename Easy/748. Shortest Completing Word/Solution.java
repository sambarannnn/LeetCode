class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap();
        String lp= licensePlate.toLowerCase();
        
        for(int i=0;i<lp.length();i++){
            char ch = lp.charAt(i);
            if(Character.isLetter(ch))
                map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int length = Integer.MAX_VALUE;
        String s = "";
        
        for(int i=0;i<words.length;i++){
            if(words[i].length()>=length)
                continue;
            
            String word = words[i];
            if(canBuild(map, word)){
                s = word;
                length = word.length();
            }
        }
        return s;
    }
    private boolean canBuild(Map<Character, Integer> map, String word){
        Map<Character, Integer> map1 = new HashMap();
        
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        
        for(char ch: map.keySet()){
            if(map.get(ch) > map1.getOrDefault(ch, 0))
                return false;
        }
        return true;
    }
}
