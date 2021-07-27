class Solution {
    public int jump(int[] nums) {
        //https://www.youtube.com/watch?v=dJ7sWiOoK7g
        
        //to maintain range
        int left = 0;
        int right = 0;
        
        int farthest = 0;
        int jumps = 0;
        //if our range does not include the last index yet, continue loop
        while(right < nums.length-1) {
            for(int i = left; i <= right; i++) {//bfs //for all values in range, find the max_reach
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1;
            right = farthest;
            jumps++;//we find a new range, so we jump to that range
        }
        return jumps;
    }
}
