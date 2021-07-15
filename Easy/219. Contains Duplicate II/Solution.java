class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
//         for(int i = 0; i < nums.length; i++) {
//             for(int j = i + 1; j < nums.length; j++) {
//                 if(nums[i] == nums[j] && Math.abs(i-j) <= k)
//                     return true;
//             }
//         }
//         return false;
        
        //num, index -> num, i
        //if we find suitable j value, we check if conditions satisfies or not
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                if(Math.abs((map.get(nums[i])) - i) <= k)
                    return true;
                //updating (i) index to higher value to yield smaller abs(i-j) value in future
                else
                    map.put(nums[i], i);
            }
        }
        return false;
    }
}
