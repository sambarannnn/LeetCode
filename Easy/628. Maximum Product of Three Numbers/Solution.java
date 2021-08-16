class Solution {
    public int maximumProduct(int[] nums) {
        // Arrays.sort(nums);
        //left two negatives will make positive and rightmost positive might also give a max product
        // return Math.max(nums[0]*nums[1]*nums[nums.length-1], nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
        
        Integer max1 = null, max2 = null, max3 = null, min1 = null, min2 = null;
        for(int num : nums) {
            
            if(max1 == null || num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;                    
            } else if(max2 == null || num >= max2) {
                max3 = max2;
                max2 = num;
            } else if(max3 == null || num >= max3) {
                max3 = num;
            }
            if(min1 == null || min1 >= num) {
                min2 = min1;
                min1 = num;
            } else if(min2 == null || min2 >= num) {
                min2 = num;
            }
        }

        return Math.max(min1*min2*max1, max1*max2*max3);
        
    }
}
