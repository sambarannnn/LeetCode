class Solution {
    /*//O(n^2) solution start from end of array, if next element(behind the curr) is same as curr, then move all elements from right end one space behind.
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        int count = 0;
        for(int i = l-1; i > 0; i--) {
            if(nums[i] == nums[i-1])
            {
                for(int j = i-1; j < l-1; j++) {
                    nums[j] = nums[j+1];
                }
                count++;
            }
        }
        return l-count;
    }
    */
    public int removeDuplicates(int[] nums) {
        //O(N) SOLUTION
        int j=0;
        //imagine the array to me majorly comprise of duplicates
        //our job is to find the unique ones and move them towards the front
        //j is used to populate the left side of the array with unique elements
        //start i from 1 and keep incrementing i until u find a different element than at j index
        for(int i=1;i<nums.length;i++) {
            //if it's a different element then add that unique element to j's next index
            if(nums[i]!=nums[j]) {
                j++;
                nums[j]=nums[i];
            }
            //incrementing i
        }
        //now, i is at null and j is pointing at last unique element in the array
        //thus, no. of unique elements = j+1;
        return j+1;
    }
}
