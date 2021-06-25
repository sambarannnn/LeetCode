public class Solution {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target)
                return mid;
            
            if(nums[start] <= nums[mid]) {//sorted till here
                if(target < nums[mid] && target >= nums[start])//if target lies in SORTED left half
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            
            if(nums[end] >= nums[mid]) {//sorted 2nd half
                if(target > nums[mid] && target <= nums[end])//lies in SORTED 2ndhalf
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
