class Solution {
    public int splitArray(int[] nums, int m) {
        //if i have only one subarray, all nums will be contained here (high)
        //if i have m number of elements in nums, all subarrays will have one element each
        //so minimum largest sum will be HIGHEST value of num here
        int low = Integer.MAX_VALUE;
        int high = 0;
        for(int num : nums) {
            low = Math.min(low, num);
            high += num;
        }
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(isPossible(nums, m, mid)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
    public static boolean isPossible(int[] nums, int max_containers, int max_sum) {
        int container_count = 1;
        int curr_sum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            curr_sum += nums[i];
            if(curr_sum > max_sum) {
                container_count++;
                curr_sum = nums[i];
                if(curr_sum > max_sum || container_count > max_containers)
                    return false;
            }
        }
        return true;
    }
}
