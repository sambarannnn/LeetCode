class KthLargest {

    int k;
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums) {
            minheap.add(num);
            if(minheap.size() > k) {
                minheap.remove();
            }
        }
    }
    
    public int add(int val) {
        minheap.add(val);
        while(minheap.size() > k)
            minheap.remove();
        return minheap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
