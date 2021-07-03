class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        //make a dynamic array to store maximum amount that can be robbed till that partucalar house
        int[] dp = new int[nums.length+1];
        dp[0] = 0;//if u rob no house, u have 0 amount
        dp[1] = nums[0];//max till first house is just first house's amount
        //every point in dp array is the max amount we can rob till this house
        for(int i = 1; i < nums.length; i++) {//for each house, calculate max amount
                    //dp[i] = previous max
                    //or old max + new house(we skip previous max as we cannot rob consecutive houses)
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }
        //now after visiting last house, we have the max value we ccan rob in the last element of dp array
        return dp[nums.length];
        /*
        //ALTER : in dp array, store maximum that can be robbed either from this house plus one house before or 2 houses before(basically storing all ways to reach this particular house)
        if(nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        if(nums.length == 2)
            return Math.max(dp[0], dp[1]);
        dp[2] = nums[2] + dp[0];
        for(int i = 3; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i-3], dp[i-2]);
        }
        return Math.max(dp[nums.length-1], dp[nums.length-2]);
        */
    }
}
