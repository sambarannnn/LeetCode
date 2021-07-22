class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int length = 0;

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() % 2 == 0) {
                length += entry.getValue();
                map.put(entry.getKey(), 0);
            } else if(entry.getValue()-2 > 0) {//odd but not 1
                length += entry.getValue() - 1;
                map.put(entry.getKey(), 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1){
                length++;
                break;
            }
        }
        return length;
    }
}
