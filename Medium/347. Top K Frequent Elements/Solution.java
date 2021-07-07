class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if (k == nums.length) {
            return nums;
        }
        
        //hashmap to track frequency
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        //creating maxheap                                          //custom comparison
        PriorityQueue<Map.Entry<Integer, Integer>> maxheap = new PriorityQueue<>((n1, n2) -> n2.getValue()-n1.getValue());
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxheap.add(entry);
        }
        //now highest frequency ele is at root
        int[] res = new int[k];
        int i = 0;
        while(i < k){
            Map.Entry<Integer, Integer> entry = maxheap.poll();
            res[i++] = entry.getKey();
        }
        return res;
    }
}
