class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;//in case k is bigger than size of array
        //we can use an extra array
        //store every ith element in (i+k)%nums.length position in auxilliary array
        //modulo operator helps us wrap around the array
        //finally we can copy the elements of this auxilliary array into original array
        /*
        int[] aux = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            aux[(i+k)%nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = aux[i];
        }
        */
        //O(n) time and O(1) space approach
        //first reverse the entire array
        reverse(nums, 0, nums.length - 1);
        //reverse first k elements
        reverse(nums, 0, k-1);//left part
        //reverse remaining elements
        reverse(nums,k, nums.length - 1); //right part
    }
    private void reverse(int[] nums, int startindex, int endindex) {
        while(startindex < endindex) {
            int temp = nums[startindex];
            nums[startindex++] = nums[endindex];
            nums[endindex--] = temp;
        }
    }
}
