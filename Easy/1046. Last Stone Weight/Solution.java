class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>((a,b) -> b-a);
        
        for(int stone : stones) {
            maxheap.add(stone);
        }
        while(maxheap.size() > 1) {
            int y = maxheap.remove();
            int x = maxheap.remove();
            maxheap.add(y-x);
        }
        return maxheap.remove();
    }
}
