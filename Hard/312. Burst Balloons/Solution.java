class Solution {
    private int[][] memo; 
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length+2];
        arr[0] = 1;
        for(int i = 1; i < arr.length-1; i++) {
            arr[i] = nums[i-1];
        }
        arr[arr.length-1] = 1;
        memo = new int[arr.length+1][arr.length+1];
        return solver(arr, 1, arr.length-1);
    }
    private int solver(int[] arr, int i, int j) {
        if(i == j)
            return 0;
        if(memo[i][j] != 0)
            return memo[i][j];
        int max = Integer.MIN_VALUE;
        for(int k = i; k < j; k++) {
            int curr = arr[i-1]*arr[k]*arr[j] + solver(arr, i, k) + solver(arr, k+1, j);
            max = Math.max(max, curr);
        }
        return memo[i][j] = max;
    }
}
