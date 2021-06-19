class Solution {
    public String longestCommonPrefix(String[] strs) {
        //O(N) solution runtime : 0ms
        //if only one string is given, then thats the LCP
        if (strs.length == 1) {
            return strs[0];
        }
        //first find shortest string
        String shortestString = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            if (shortestString.length() < strs[i].length()) {
                shortestString = strs[i];
            }
        }
        //compare shortest string with all other strings
        //it will keep shortening until it matches as an equal prefix to all strings
        for (int i = 0; i < strs.length; ++i) {
            //for this particular string, it will keep reducing shortest string till it matches
            while (!strs[i].startsWith(shortestString) && !shortestString.isEmpty()) {
                shortestString = shortestString.substring(0, shortestString.length() - 1);
            }
            //if its empty now then no use checking other strings, so break out of loop
            if(shortestString.isEmpty())
                break;
            //now shortest string is LCP for all strings until this index(i), repeat process for further strings(incrementin i with loop)
        }
        return shortestString;
    }
}
