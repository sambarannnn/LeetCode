class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr_count = 0;
        int max_count = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                curr_count++;
            } else {
                max_count = Math.max(max_count, curr_count);
                curr_count = 0;
            }
        }
        //in case the last set of 1s till array's last index was the max
        max_count = Math.max(max_count, curr_count);
        return max_count;
    }
}
