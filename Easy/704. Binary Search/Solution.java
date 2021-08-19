class Solution {
    public int search(int[] nums, int target) {
        return Bsearch(nums, 0, nums.length-1, target);
    }
    private int Bsearch(int[] nums, int left, int right, int target) {
        if(left > right)
            return -1;
        
        int mid = left + (right-left)/2;
        
        if(nums[mid] == target)
            return mid;
        
        else if(nums[mid] > target)
            return Bsearch(nums, left, mid-1, target);
        else
            return Bsearch(nums, mid+1, right, target);
    }
}
