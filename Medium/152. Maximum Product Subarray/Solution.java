class Solution {
    public int maxProduct(int[] nums) {
        //https://www.youtube.com/watch?v=vtJvbRlHqTA
        
        //lets keep a track of min as well as mix
        //we keep a track of min as min multiplied by a negative element might give us a max value
        //of we encounter a 0, our min and max values are reset to zero, as next subarray will begin after 0
        //if we encounter positive number, and our max is positive, new max will be max*number, (howmuch ever big the number is, it will only get bigger by multiplying)
        //if we encounter negative number, and our prev min is negative, we might get a positive number bigger than the curr max value, so it is important to keep a track of that
        
        //set to 0th element to handle edge case of the array containing only one element
        int currmax = nums[0];//starting from 0th index, currmax, currmax value resets for starting for different indices automatically
        //DRY RUN : {-1, 6, 2, 0, 7 ,9} to visualise all cases
        int currmin = nums[0];
        int prevmax = nums[0];
        int prevmin = nums[0];
        int result = currmax;
        for(int i = 1; i < nums.length; i++) {
                //both positive or both negative or we had previously encountered a zero
            //gives us three conditions to checkfor max
            currmax = Math.max((prevmax * nums[i]), Math.max((prevmin * nums[i]), nums[i]));
            //keep a track of min too, might come in handy later
            currmin = Math.min((prevmax * nums[i]), Math.min((prevmin * nums[i]), nums[i]));
            
            result = Math.max(result, currmax);
            
            prevmax = currmax;
            prevmin = currmin;
        }
        return result;
    }
}
