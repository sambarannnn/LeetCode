class NumArray {
    static int[] sums;
    public NumArray(int[] nums) {
        //for nums : 1,2,3,4 -> length = 4
        //sums : 0, 1, 3, 6, 10 -> length = 5
        
        sums = new int[nums.length + 1];
        //sums[0] is set to 0, to not subtract any value from the upper bound of the range if sum of range between (0-4) -> sum of elements till index 4
        sums[0] = 0;
        for(int i = 0; i < sums.length - 1; i++) {
            sums[i+1] = sums[i] + nums[i];//sum till this index is stored in sums[i+1]
        }
    }
    
    public int sumRange(int left, int right) {
        //to find sum in range (1-3)
        //sum till index 0 : 1
        //sum till index 1 : from nums, 1+2
        //sum till index 3 : from nums, 1+2+3+4
        //thus, sum of range (1-3) -> 2+3+4 -> sum till index 3 - sum till index 0(1-1) 
        
        //sum till index i is stored in sums[i+1]
        //sum of range : sum till upper bound - sum till (lowerbound-1):so as to not subtract lowerbound itself
        return sums[right+1] - sums[left+1 - 1];
    }
}
