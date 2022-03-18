class Solution {
    public String smallestSubsequence(String s) {
        HashMap<Character, Integer> freq_map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            freq_map.put(c, freq_map.getOrDefault(c, 0) + 1);
        }
        Stack<Character> stack = new Stack<Character>();
        HashSet<Character> visited = new HashSet<Character>();
        for(char c : s.toCharArray()) {
            freq_map.put(c, freq_map.get(c)-1);
            if(visited.contains(c)) {
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > c && freq_map.get(stack.peek()) > 0) {
                visited.remove(stack.pop());
            }
            stack.push(c);
            visited.add(c);
        }
        StringBuilder res = new StringBuilder();
        for(char c : stack) {
            res.append(c);
        }
        return res.toString();
    }
}
