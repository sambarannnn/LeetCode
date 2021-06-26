class Solution {
    public int[] searchRange(int[] nums, int target) {
        /*
        //once you find the element, expand left and right till equal elements
        int start = 0;
        int end = nums.length - 1;
        int l = -1;
        int r = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else if(nums[mid] == target) {
                l = mid;
                r = mid;
                while(l >= 0 && nums[l] == target) l--;
                while(r < nums.length && nums[r] == target) r++;
                l++;
                r--;
                break;
            }
        }
        
        return new int[]{l, r};
        */
        int start = 0;
        int end = nums.length - 1;
        if(nums == null || nums.length == 0)
            return new int[] {-1, -1};
        while(start < end) {
            int mid = (start + end) / 2;
            //System.out.println("1");
            if(nums[mid] < target)
                start = mid+1;
            else if(nums[mid] >= target)//this is first ele or first ele is towards the left of here
                end = mid;//combined smaller and equal portions
        }
        //now, start should be pointing at first occurence of element
        if(nums[start] != target)
            return new int[] {-1, -1};
        int leftindex = start;
        end = nums.length-1;
        while(start < end) {
            //System.out.println("2");
            //When we use mid = (start+end)/2, the mid is rounded to the lowest integer. In other words, mid is always biased towards the left. This means we could have start == mid when end - start == mid, but we NEVER have end == mid. So in order to keep the search range moving, you must make sure the new start is set to something different than mid, otherwise we are at the risk that i gets stuck.
            int mid = ((start + end) / 2) + 1;// Make mid biased to the right
            if(nums[mid] > target)
                end = mid -1;
            else if(nums[mid] <= target)//this is last ele or last ele is to the right of here
                start = mid;
        }
        int rightindex = start;
        return new int[]{leftindex, rightindex};
    }
}
