class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        HashMap<String, Integer> freq_map = new HashMap<String, Integer>();
        for(String word : words) {
            freq_map.put(word, freq_map.getOrDefault(word, 0) + 1);
        }
        int wordLength = words[0].length();
        int slow = 0;
        int fast = wordLength;
        
        for(int start = 0; start <= s.length() - wordLength * words.length; start++) {
            
            HashMap<String, Integer> curr_freq_map = new HashMap<String, Integer>(freq_map);
            int counter = curr_freq_map.size();
            int curr = start;
            while(curr + wordLength <= s.length()) {
                String word = s.substring(curr, curr + wordLength);
                if(curr_freq_map.containsKey(word)) {
                    if(curr_freq_map.get(word) == 0) {//word is already exhausted but it is repeating again
                        break;
                    }
                    curr_freq_map.put(word, curr_freq_map.get(word) - 1);
                    if(curr_freq_map.get(word) == 0) {
                        counter--;
                    }
                    if(counter == 0) {
                        // System.out.println(word);
                        res.add(start);
                        break;
                    }
                    curr += wordLength;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
