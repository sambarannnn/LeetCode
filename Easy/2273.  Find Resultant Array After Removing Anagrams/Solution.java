class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        for(String word : words) {
            if(!stack.isEmpty() && areAnagrams(stack.peek(), word)) {
                continue;
            }
            stack.push(word);
        }
        for(String word : stack) {
            res.add(word);
        }
        return res;
    }
    public boolean areAnagrams(String a, String b) {
        int[] map = new int[26];
        for(char c : a.toCharArray()) {
            map[c-'a']++;
        }
        for(char c : b.toCharArray()) {
            map[c-'a']--;
        }
        for(int x : map) {
            if(x != 0) {
                return false;
            }
        }
        return true;
    }
}
