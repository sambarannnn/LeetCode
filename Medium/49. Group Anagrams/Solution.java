class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs) {
            char temp[] = s.toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);
            
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
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
