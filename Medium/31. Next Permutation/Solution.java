class Solution {
    public void nextPermutation(int[] nums) {
        //think of the nums array as a single number
        //we have to rearrange the existing digits of this number to find the next greatest number
        //to do this, from the ones side of the number(from right), we find the first peak
        //to the left of this peak, we have a digit that is smaller than all the ones to it's right
        //so, to find the NEXT greater(least possible greater) element, we can swap this with the least possible digit from the right of this peak, which is greater than this trough element that we have just found
        //when we swap it, we have a greater element, but note that the right side of the peak is now, a decreasing sequence,
        //so, to further make this a smaller number(STILL GREATER THAN THE ORIGINAL NUMBER), we can swap the elements of the decreasing sequence so that this sequence becomes an increasing subsequence : WE ARE BASICALLY MOVING THE HIGH VALUE DIGITS(BIG ONES) TO THE ONES SIDE(TOWARDS RIGHT) SO THAT THE NUMBER BECOMES SMALLER
        //SPECIAL CASE :
        //if we are unable to find the first peak(SUBSEQUENT TROUGH), this means that the entire sequence is a decreasing subsequence ie. no further greater permutation can be found
        //so we just rearrange it in ascending order(LEAST POSSIBLE ORDER)
        
        if(nums.length == 0 || nums.length == 1)
            return;
        
        int trough_index = nums.length - 2;
        while(trough_index >= 0 && nums[trough_index+1] <= nums[trough_index])
            trough_index--;
        //now index is at first trough from the right
        //check if index is -1 which would mean
        if(trough_index != -1) {
            //we need to find the first element greater than this trough from the right
            int nge_index = nums.length - 1;
            while(nums[nge_index] <= nums[trough_index])
                nge_index--;
            //now, nge_index is pointing to the first greater element from te right
            //lets swap these two
            int temp = nums[trough_index];
            nums[trough_index] = nums[nge_index];
            nums[nge_index] = temp;
        }
        //now, does,nt matter if we have performed the above if statement or not, we have a decreasing sequence on our hands that we need to reverse the decreasing subsequence starting from trough_index+1
        //using two pointer approach
        int left = trough_index+1;
        int right = nums.length-1;
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
