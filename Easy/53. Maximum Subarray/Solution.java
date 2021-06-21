class Solution {
    public int maxSubArray(int[] nums) {
        int maxcurr = nums[0];//to track current segment's max
        int max_final = nums[0];// to track max ever value encountered yet
        for(int i = 1; i < nums.length; i ++) {
            maxcurr = Math.max(maxcurr + nums[i], nums[i]);//either continue(include this element to maxcurr summ) or break(make this element start of new maxcurr sum) and start again from this element
            max_final = Math.max(maxcurr, max_final);
        }
        return max_final;
    }
}
