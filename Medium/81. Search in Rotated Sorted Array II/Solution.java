class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end) {
            int mid = start + (end-start)/2;
            
            if(nums[mid] == target)
                return true;
            if(nums[mid] > nums[start] || nums[mid] > nums[end]) {//left side is sorted OR right side is unsorted
                if(target >= nums[start] && target < nums[mid])
                    end = mid-1;
                else
                    start = mid+1;
            } else if(nums[mid] < nums[end] || nums[mid] < nums[start]) {//right side is sorted or left side is unsorted
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else 
                    end = mid - 1;
            } else {// we dont know anything for sure
                start++;//just removing one duplicate
            }
        }
        return false;
    }
}
