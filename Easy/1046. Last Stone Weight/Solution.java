class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>((a, b) -> b-a);
        
        for(int stone : stones) {
            maxheap.add(stone);
        }
        
        while(maxheap.size() > 1) {
            int y = maxheap.remove();//bigger no at root
            int x = maxheap.remove();
            maxheap.add(y-x);//if y and x are equal it will add 0
        }
        return maxheap.peek();
    }
}
