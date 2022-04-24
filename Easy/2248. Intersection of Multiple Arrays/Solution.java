class Solution {
    public List<Integer> intersection(int[][] nums) {
        TreeMap<Integer, Integer> sorted_map = new TreeMap<Integer, Integer>();//treemap holds sorted keys
        for(int[] arr : nums) {
            for(int i : arr) {
                sorted_map.put(i, sorted_map.getOrDefault(i, 0)+1);
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> entry : sorted_map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if(freq == nums.length) {//present in all rows
                res.add(num);
            }
        }
        return res;
    }
}
