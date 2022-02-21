class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) {
            return "";
        }
        HashMap<Character, Integer> freq_map = new HashMap<Character, Integer>();
        for(char c : t.toCharArray()) {
            freq_map.put(c, freq_map.getOrDefault(c, 0) + 1);
        }
        String res = "";
        int slow = 0;
        int fast = 0;
        int counter = freq_map.size();
        while(fast < s.length()) {
            if(freq_map.containsKey(s.charAt(fast))) {
                freq_map.put(s.charAt(fast), freq_map.get(s.charAt(fast)) - 1);
                if(freq_map.get(s.charAt(fast)) == 0) {
                    counter--;
                }
            }
            while(counter == 0) {//we have reached at counter = 0, so keep moving slow ahead while counter is still 0, some elements might have been repeated in this substring, so they might have negative frequencies at this point
                if(res.length() == 0 || res.length() > s.substring(slow, fast+1).length()) {
                    
                    res = s.substring(slow, fast+1);
                }
                if(freq_map.containsKey(s.charAt(slow))) {
                    freq_map.put(s.charAt(slow), freq_map.get(s.charAt(slow)) + 1);
                    if(freq_map.get(s.charAt(slow)) > 0) {
                        counter++;
                    }
                }
                slow++;
            }
            fast++;
        }
        return res;
    }
}
