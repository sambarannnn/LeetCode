class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % 2 != 0)//if sum is odd, we cant make 2 equal subset sums
            return false;
        
        //now we need to find if we can partition the array into two parts such that both parts have an equal sum, say S. and S+S = sum
        //thus, we need to find such a subset of the array whose sum is (sum/2)
        //if we find this, automatically there will be another subset with (sum/2) sum to satisfy our condition
        int target = sum/2;
        boolean[][] dp = new boolean[nums.length+1][target+1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                if(i == 0)
                    dp[i][j] = false;
                if(j == 0)
                    dp[i][j] = true;
            }
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++) {
                if(nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}
