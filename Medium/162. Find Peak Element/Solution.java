public class Solution {
    public int findPeakElement(int[] nums) {
        //plot as a graph to visualise binary search approach
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right) {
            int mid = (left + right) / 2;
            
            if(nums[mid] < nums[mid+1]) {//there has to exist a peak to the right
                left = mid+1;
            } else {//there has to exist a peak to the left(or itself is a peak)
                right = mid;
            }
        }
        return left;//or return right
        
        // //O(N^2)
        // for (int i = 0; i < nums.length - 1; i++) {
        //     if (nums[i] > nums[i + 1])
        //         return i;
        // }
        // return nums.length - 1;
    }
}
