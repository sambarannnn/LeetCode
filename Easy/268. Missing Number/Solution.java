class Solution {
    public int missingNumber(int[] nums) {
        //for O(N)
        //sum of all the elements in the array should be equal to the sum of all elements until the nums.length(size of array : max element)
        //difference will give us missing element
        //gaussian formuula
        //sum until n nos = n(n+1)/2
        
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualsum = 0;
        for(int i = 0; i < nums.length; i++)
            actualsum+=nums[i];
        int difference = expectedSum - actualsum;
        
        return difference;
        
        /*O(NLOGN) approach
        //we can sort the array, then check if last element is equal to lenght of given array and first element is zero, thereafter check if every element in [1..n-1] is incremented by one
        Arrays.sort(nums);

        // Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }
        //start from 1, check the prev num, it should be curr = prev+1
        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;//missing element
            }
        }
        return -1;//no missing element
        */
    }
}
