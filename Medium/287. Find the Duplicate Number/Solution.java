class Solution {
    public int findDuplicate(int[] nums) {
        // Arrays.sort(nums);
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] == nums[i-1]) {
        //         return nums[i];
        //     }
        // }
        // return -1;
        //use a set
        //adding any duplicate element will notify
        // HashSet<Integer> set = new HashSet<Integer>();
        // for (int num : nums) {
        //     if (set.contains(num)) {
        //         return num;
        //     }
        //     set.add(num);
        // }
        // return -1;
        
        //ARRAY IS IMMUTABLE AND WE NEED TO FIND SOLN WITH CONSTANT SPACE
        //we have n+1 sized array indexed 0-n
        //elements are in the range 1-n
        //we can traverse indexes using tha value at each index
        //there will always be a cycle
        int slow = nums[0];
        int fast = nums[0];
        //we will never come bak to index zero as all elements are 1-n
        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while(slow != fast);
        
        //when slow == fast, cycle is detected
        
        //reset slow to 0th index
        //now move both slow and fast pointers at same pace
        //both of them will proceed towards intersection point
        //when fast and slow pointer are equal, we have found our repeating element even before the intersection point perhaps
        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
