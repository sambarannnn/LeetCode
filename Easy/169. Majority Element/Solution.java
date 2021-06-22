class Solution {
    public int majorityElement(int[] nums) {
        //given in question that majority element occupies more than half of nos
         Arrays.sort(nums);
         return nums[nums.length/2];

        /*
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int i : nums){
            int value = hm.getOrDefault(i, 0) + 1;
            hm.put(i, value);
        }
        
        Map.Entry<Integer, Integer> maxEntry = null;
        
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
        if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) 
            maxEntry = entry;
        }
        return maxEntry.getKey();
        */
    }
}
