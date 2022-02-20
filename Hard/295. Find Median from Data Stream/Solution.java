class MedianFinder {

    boolean total_is_even;
    PriorityQueue<Integer> maxheap_left;
    PriorityQueue<Integer> minheap_right;
    public MedianFinder() {
        maxheap_left = new PriorityQueue<Integer>(Collections.reverseOrder());
        minheap_right = new PriorityQueue<Integer>();
        total_is_even = true;
    }
    
    public void addNum(int num) {
        if(total_is_even) {
            minheap_right.add(num);
            maxheap_left.add(minheap_right.remove());//add extra to left
            
        } else {//left already has one extra
            maxheap_left.add(num);
            minheap_right.add(maxheap_left.remove());//equalise by adding one to right
        }
        total_is_even = !total_is_even;
    }
    
    public double findMedian() {
        if(total_is_even) {
            return (maxheap_left.peek() + minheap_right.peek()) / 2.0;
        } else {
            return maxheap_left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
