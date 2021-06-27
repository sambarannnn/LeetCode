class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs) {
            char key[] = s.toCharArray();
            Arrays.sort(key);
            //System.out.println(String.valueOf(key));
            if (!map.containsKey(String.valueOf(key))){
                //System.out.println(String.valueOf(key));
                map.put(String.valueOf(key), new ArrayList<String>());
            }
            
            map.get(String.valueOf(key)).add(s);
            //System.out.println(map.get(String.valueOf(key)));
            //strs[i++] = String.valueOf(tempArray); //.toString();
        }
        
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            //System.out.print(entry.getKey()+" : ");
            List<String> lst = entry.getValue();
            res.add(lst);
            //System.out.println(lst.size());
            /*for(int i = 0; i < lst.size(); i++) {
                System.out.print(lst.get(i) + " ");
            }
            System.out.println();
            */
        }
        
        return res;
    }
}
