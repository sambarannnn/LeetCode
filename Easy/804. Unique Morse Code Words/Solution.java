class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] map = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        StringBuilder morse;
        for(String word : words) {
            morse = new StringBuilder();
            for(char c : word.toCharArray()) {
                morse.append(map[c-97]);
            }
            set.add(morse.toString());
        }
        return set.size();
    }
}
