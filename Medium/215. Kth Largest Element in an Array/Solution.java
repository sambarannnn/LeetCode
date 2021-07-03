class Solution {
    public int findKthLargest(int[] nums, int k) {
        //  We can use min heap
        //in min heap, top of the tree will contain minimum element
        //in order to find kth largest element from min heap, pop n-k+1 times 
        PriorityQueue<Integer> minheap = new PriorityQueue<>();//by default it implements minheap
        //every insertion moves min element to the root
        for(int i : nums) {
            minheap.add(i);
            //or, you can also make it so that at all times, min heap has at most k elements, so by the end of the adding of all elements(and subsequent removals) kth largest element will be at root,
            if(minheap.size() > k)
                minheap.remove();
        }
        //not required if you maintain if statement in loop
        // for(int i = 0; i < nums.length-k; i++)
        //     minheap.remove();
        
        //now, kth largest element is at root
        return minheap.remove();
        
        //ALTER
        // Arrays.sort(nums);
        // return nums[nums.length-k];
    }
}
