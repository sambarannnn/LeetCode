class Solution {
    public char findTheDifference(String s, String t) {
        //single pass solution
        
        // since t has only one extra character
        //sum of all chars in t minus sum of all chars in s should give us the extra character
        int sums = 0;
        int sumt = 0;
        for(int i = 0; i < s.length(); i++) {
            sums += (int)s.charAt(i);
            sumt += (int)t.charAt(i);
        }
        sumt += (int)t.charAt(t.length() - 1);//last extra character which wasnt added in loop as it was according to s's length
        
        return (char)(sumt-sums);
        
//         HashMap<Character, Integer> frequency_map = new HashMap<Character, Integer>();
//         for(char c : s.toCharArray()) {
//             frequency_map.put(c, frequency_map.getOrDefault(c, 0)+1);
//         }
        
//         for(char c : t.toCharArray()) {
//             if(!frequency_map.containsKey(c) || frequency_map.get(c) == 0)
//                 return c;
//             frequency_map.put(c, frequency_map.get(c) - 1);
//         }
//         return '-';//not found
    }
}
