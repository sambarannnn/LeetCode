class Solution {
    public int arrayPairSum(int[] nums) {
//         the sum of all number is fixed, 
    // to maximize the sum of smaller group, you want to minimize the diff of the sum of 2 groups.
// And the best way to do that is to pair the numbers that are next to each other in sorted order.
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i <= nums.length-2; i+=2) {
            sum += Math.min(nums[i], nums[i+1]);
        }
        return sum;
    }
}
