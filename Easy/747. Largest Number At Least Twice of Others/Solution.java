class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int max_index = -1;
        int max2 = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max2 = max;
                max = nums[i];
                max_index = i;
                
            } else if(nums[i] > max2) {
                max2 = nums[i];
            }
        }
        if(max >= max2*2) {
            return max_index;
        }
        return -1;
    }
}
