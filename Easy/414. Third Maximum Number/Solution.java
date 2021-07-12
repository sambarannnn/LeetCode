class Solution {
    public int thirdMax(int[] nums) {
        //O(N)
        //we use three variables
        //we could have initialized then to integer.min value but if nums has an integer.min value, our calculations would be affected
        //so we can either use a long, or use Integer null
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        
        for(Integer num : nums) {
            //skipping duplicates
            if(num.equals(max1) || num.equals(max2) || num.equals(max3))
                continue;
            if(max1 == null || max1 < num) {
                //if we update max1 to new value, max2 should take it's prev value; max3 should take max2's previous value
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if(max2 == null || max2 < num) {
                max3 = max2;
                max2 = num;
            } else if(max3 == null || max3 < num) {
                max3 = num;
            }
        }
        if(max3 == null)
                return max1;
            
        return max3;
        
        /* //O(NLOGN)
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();//minheap
        //every insertion rearranges the heap such that local min element is at root
        for(int i = 0; i < nums.length; i++) {
            if(!minheap.contains(nums[i])){//ensuring that we don't add duplicate elements to our maxheap
                minheap.add(nums[i]);
                //if we have more than 3 elements, lets pop one : it will remove the min element
                if(minheap.size() > 3)
                    minheap.remove();
            }
        }
        //at this point, there should be 3 elements in the minheap, and smallest element should be at root
        
        //smallest element will be at root
        //in case the heap doesn't have 3 elements, we do not have a third max, so we should return the max element
        if(minheap.size() < 3) {//pop everything
            while(minheap.size() > 1) {//we pop until one element is left
                minheap.remove();
            }
            //now, last element left is the max element
            return minheap.remove();
        }
        
        //otherwise, we have 3 elements at the root(max of all the nums elements), the smallest of those three are at the root (which is thirdmax of nums[])
        return minheap.remove();
        */
    }
}
