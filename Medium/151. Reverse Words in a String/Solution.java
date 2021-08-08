class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        res.append(words[words.length-1]);
        for(int i = words.length-2; i >=0; i--) {
            res.append(" " + words[i]);
        }
        return res.toString();
    }
}
