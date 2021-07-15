class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    
        //use a hashset to maintain at max k+1()0-indexed elements at a time
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            //check if i has become bigger than k
            //so we will have to keep removing the first element from this "window" of k+1 elements
            //in that case, we remove the first element that we added in this (k+1)-element set
            //first element can be found by going k steps back from prev element i.e., nums[i-k-1](since 0 indexed)
            if(i > k)
                set.remove(nums[i - k - 1]);
            
            //now, if you are unable to add element into the set, it means we already have it present in the set, which only has elements in the k+1 element window
            if(!set.add(nums[i]))
                return true;
        }
        return false;
        
        
        // //num, index -> num, i
        // //if we find suitable j value, we check if conditions satisfies or not
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for(int i = 0; i < nums.length; i++) {
        //     if(!map.containsKey(nums[i])) {
        //         map.put(nums[i], i);
        //     } else {
        //         if(Math.abs((map.get(nums[i])) - i) <= k)
        //             return true;
        //         //updating (i) index to higher value to yield smaller abs(i-j) value in future
        //         else
        //             map.put(nums[i], i);
        //     }
        // }
        // return false;
    }
}
