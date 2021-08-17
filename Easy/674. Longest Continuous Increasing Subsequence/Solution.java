class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int len = 1;
        int maxLen = 1;
        
        for(int i = 1; i < nums.length; i++) {
            len = 1;
            while(i < nums.length && nums[i] > nums[i-1]) {
                i++;
                len++;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
