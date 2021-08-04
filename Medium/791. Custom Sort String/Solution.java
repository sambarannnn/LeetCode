class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sortedString = new StringBuilder();
        //find frequency of all the chars in string
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        //for the elements in order, append them*no of their freq times to the stringbuilder
        for(char c : order.toCharArray()) {
            if(!map.containsKey(c))
                continue;
            
            while(map.get(c) > 0) {
                sortedString.append(c);
                map.put(c, map.get(c)-1);
            }
        }
        for(char c : s.toCharArray()){
            while(map.get(c) > 0) {
                sortedString.append(c);
                map.put(c, map.get(c)-1);
            }
        }
        
        return sortedString.toString();
        // HashSet<Character> set = new HashSet<>();
        // //find each occurence of custom sort char and add them to the stringbuilder
        // for(char c : order.toCharArray()) {
        //     for(int i = 0; i < s.length(); i++) {
        //         if(s.charAt(i) == c)
        //             sortedString.append(s.charAt(i));
        //     }
        //     set.add(c);
        // }
        // //add the remaining chars
        // for(int i = 0; i < s.length(); i++) {
        //     if(!set.contains(s.charAt(i)))//as these values have already been added to the sortedstring
        //         sortedString.append(s.charAt(i));
        // }
        // return sortedString.toString();
    }
}
