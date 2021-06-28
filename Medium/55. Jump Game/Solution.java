class Solution {
    public boolean canJump(int[] nums) {
        //idea is to start from 2nd last index, and keep decrementing left until the value at current index is not zero
        //as long as element at curr index is not zero, we can continue to next index and so on
        //if we encounter 0, we need to find element behind current index that can jump ahead of the 0 in front of it
        //so we keep decrementing behind the zero until we find an element whose value will enable it to jump past the 0 element
        //in this process, if we reach behind first index, no such element exists in the array that can jump past the 0 element
        //so we return false
        
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] == 0) {
                int required_JumpLength = 1;
                while(nums[i] < required_JumpLength) {
                    i--;
                    required_JumpLength++;
                    if(i < 0)
                        return false;
                }
            }
        }
        return true;
        
        
        /*
        //GREEDY ALGORITHM
        int reachable = 0;//max reachable index
        
        for(int i = 0; i < nums.length; i++) {
            if(i > reachable)//we have reached an unreachable index
                return false;
            
            reachable = Math.max(reachable, i + nums[i]);//prev max reachable or max jump from this index
            if(reachable == nums.length - 1)//we can reach last index from here
                break;
        }
        return true;
        */
    }
}
