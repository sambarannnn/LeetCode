class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        long currSum = 0;
        for(int i = 0; i < k; i++) {
            currSum += nums[i];
        }
        long maxSum = currSum;
        //avoiding division till ending
        // double maxAvg = currSum / (double) k;
        int slow = 0;
        int fast = k;
        for(fast = k; fast < nums.length; fast++, slow++) {
            currSum = currSum - nums[slow] + nums[fast];
            // maxAvg = Math.max(currSum/(double)k, maxAvg);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum/(double)k;
    }
}
