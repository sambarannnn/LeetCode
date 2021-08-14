class Solution {
    public int findLHS(int[] nums) {
//         Arrays.sort(nums);
//         int prevCount = 0;
//         int maxSize = 0;
        
//         for(int i = 0; i < nums.length; i++) {
//             int currCount = 1;
            
//             if(i > 0 && nums[i] - nums[i-1] == 1) {
//                 while(i < nums.length-1 && nums[i] == nums[i+1]) {
//                     i++;
//                     currCount++;
//                 }
//                 maxSize = Math.max(maxSize, prevCount + currCount);
//             } else {
//                 while(i < nums.length-1 && nums[i] == nums[i+1]) {
//                     i++;
//                     currCount++;
//                 }
//             }
//             prevCount = currCount;
//         }
//         return maxSize;
        int maxSize = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for(int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
            if(freqMap.containsKey(i+1)) {
                maxSize = Math.max(maxSize, freqMap.get(i) + freqMap.get(i+1));
            }
            if(freqMap.containsKey(i-1)) {
                maxSize = Math.max(maxSize, freqMap.get(i) + freqMap.get(i-1));
            }
        }
        // for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
        //     int num = entry.getKey();
        //     int freq1 = entry.getValue();
        //     if(freqMap.containsKey(num+1)) {
        //         int freq2 = freqMap.get(num+1);
        //         maxSize = Math.max(maxSize, freq1 + freq2);
        //     }
        // }
        return maxSize;
    }
}
