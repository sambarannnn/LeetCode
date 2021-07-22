class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int length = 0;

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() % 2 == 0) {//even frequency
                length += entry.getValue();
                map.put(entry.getKey(), 0);
            } else if(entry.getValue()-2 > 0) {//odd frequency but not 1
                length += entry.getValue() - 1;
                map.put(entry.getKey(), 1);
            }
            //after checking these two conditions, check for below condition
            if(length % 2 == 0 && entry.getValue() % 2 != 0) {//if length is even, we have the possibility for a center
                length++;
                map.put(entry.getKey(), entry.getValue()-1);
            }
        }
        return length;
    }
}
