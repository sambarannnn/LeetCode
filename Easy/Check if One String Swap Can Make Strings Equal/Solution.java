class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        HashMap<Character, Integer> freq_map = new HashMap<Character, Integer>();
        int diffCount = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
            }
            if(diffCount > 2) {
                return false;
            }
            freq_map.put(s1.charAt(i), freq_map.getOrDefault(s1.charAt(i), 0) + 1);
            freq_map.put(s2.charAt(i), freq_map.getOrDefault(s2.charAt(i), 0) - 1);
            if(freq_map.get(s1.charAt(i)) == 0) {
                freq_map.remove(s1.charAt(i));
            }
            if(freq_map.containsKey(s2.charAt(i)) && freq_map.get(s2.charAt(i)) == 0) {
                freq_map.remove(s2.charAt(i));
            }
        }
        if(diffCount == 0 || freq_map.size() == 0) {
            return true;
        }
        return false;
    }
}
