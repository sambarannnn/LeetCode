class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        HashMap<Character, Integer> freq_map = new HashMap<Character, Integer>();
        for(char c : p.toCharArray()) {
            freq_map.put(c, freq_map.getOrDefault(c, 0) + 1);
        }
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
            if(counter == 0) {
                res.add(slow);
            }
            if(fast >= p.length()-1) {
                // System.out.println(slow + " " + fast);
                char tempc = s.charAt(slow);
                if(freq_map.containsKey(tempc)) {
                    if(freq_map.get(tempc) == 0)
                        counter++;
                    freq_map.put(tempc, freq_map.get(tempc) + 1);
                }  
                slow++;
            }
            fast++;
        }
        return res;
    }
}
