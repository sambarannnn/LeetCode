class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest_sum = 0;
        int min_diff = Integer.MAX_VALUE;//we have to minimize this value
        
        for(int i = 0; i < nums.length; i++) {
            
            int left = i+1;
            int right = nums.length - 1;
            
            while(left < right) {
                int curr_sum = nums[i] + nums[left] + nums[right];
                int curr_diff = Math.abs(target - curr_sum);
                if(curr_diff == 0)
                    return curr_sum;//cant have any smaller difference in this case
                if(curr_diff < min_diff) {
                    min_diff = curr_diff;
                    closest_sum = curr_sum;
                }
                if(curr_sum < target)
                    left++;
                else
                    right--;
            }
        }
        return closest_sum;
    }
}
