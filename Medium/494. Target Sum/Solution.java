class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //array can be divided into two subsets S1 and S2
        //such that s1 has all positive and s2 has all negative
        //s1+s2 = target where s1 is all +ve and s2 is all -ve
        //taking negative common out of s2
        //s1-s2 = target both have all positive like original array
        //total sum = sum
        //s1+s2 = sum
        //s2 = sum-s1
        //s1 - (sum-s1) = target
        //2s1 - sum = target
        //s1 = sum+target/2
        //does such an s1 exist? if yes then how many we have to find this
        
        int sum = 0;
        int zeroCount = 0;
        for(int num : nums) {
            sum += num;
            if(num == 0)
                zeroCount++;//maintain number of zeroes
        }
        //edge cases : 
        //if target is out of bounds, or the target is such that it cannot be equally divided
        if(target > sum ||(sum+target)%2 != 0)
            return 0;
        if(target < 0 && target < -sum)
            return 0;
        
        int s1 = (sum + target ) / 2;
        return subsetsWithGivenSum(nums, nums.length, s1, zeroCount);
    }
    private int subsetsWithGivenSum(int[] nums, int n, int sum, int zeroCount) {
        int[][] dp = new int[n+1][sum+1];
	    for(int i = 0; i < dp.length; i++) {
	        for(int j = 0; j < dp[i].length; j++) {
	            if(i == 0)
	                dp[i][j] = 0;
	            if(j == 0)
	                dp[i][j] = 1;
	        }
	    }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++){
                if(nums[i-1] == 0) {//spcl case for zero, don't count it here
                    dp[i][j] = dp[i-1][j];
                } else if(nums[i-1] <= j){
                    dp[i][j] = (dp[i-1][j-nums[i-1]] + dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum] * (int)Math.pow(2, zeroCount);//make permutations with number of zeroes
    }
}
