class KthLargest {

    private PriorityQueue<Integer> minheap;
    private int k;
            
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minheap = new PriorityQueue<Integer>();
        for(int num : nums)
            add(num);
    }
    
    public int add(int val) {
        //if minheap is smaller than k
        if(minheap.size() < k) {
            minheap.add(val);
        } else {//if minheap is bigger than k
            if(val > minheap.peek()) {//minheap has only k elements, root of minheap is the smallest element, insert into minheap only if this new val is bigger than the smallest, as we are only interested in keeping the largest 3 in the minheap
                minheap.remove();
                minheap.add(val);
            }
        }
        return minheap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
