class Solution {
    public int searchInsert(int[] nums, int target) {
        //log n can be made using binary search
        int first = 0;
        int last = nums.length - 1;
        int mid;
        
        while(first <= last) {
            mid = (first + last)/2;
            if(nums[mid] == target)
                return mid;
            else if(target < nums[mid])
                last = mid - 1;
            else //if(target > nums[mid])
                first = mid + 1;
        }
        //in case search fails, first is pointing at index of next greater element
        //observing example shows this
        return first;
    }
}
