class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        while(left < right) {//quit while we have one element in array
            
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right])//this means it is rotated and smaller one is at right
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }
}
