class Solution {
    public int longestPalindrome(String s) {
        
        int[] frequency_map = new int[256];
        
        for(int i = 0; i < s.length(); i++) {
            frequency_map[s.charAt(i) - 0]++;
        }
        
        int odd_frq = 0;
        
        for(int c : frequency_map) {
            if(c % 2 != 0)//this char has an odd frequency
                odd_frq++;//total no of odd chars || even if a char has freq of say, 5, we will only add +1 for the "odd" character, remaining 4 can form even pairs
        }
        
        if(odd_frq == 0) {//all the chars have an even frequency, so all of them can be used
            return s.length();
        } else {
            return s.length() - odd_frq + 1;//total chars - number of odd chars + 1(for the center char which can be odd/unique)
        }
        
//         HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//         for(char c : s.toCharArray()) {
//             map.put(c, map.getOrDefault(c, 0)+1);
//         }
        
//         int length = 0;

//         for(Map.Entry<Character, Integer> entry : map.entrySet()) {
//             if(entry.getValue() % 2 == 0) {//even frequency
//                 length += entry.getValue();
//                 map.put(entry.getKey(), 0);
//             } else if(entry.getValue()-2 > 0) {//odd frequency but not 1
//                 length += entry.getValue() - 1;
//                 map.put(entry.getKey(), 1);
//             }
//             //after checking these two conditions, check for below condition
//             if(length % 2 == 0 && entry.getValue() % 2 != 0) {//if length is even, we have the possibility for a center
//                 length++;
//                 map.put(entry.getKey(), entry.getValue()-1);
//             }
//         }
//         return length;
    }
}
