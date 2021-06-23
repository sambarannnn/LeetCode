class Solution {
    public void moveZeroes(int[] nums) {
        //SNOWBALL EFFECT ALGO
        int snowBallSize = 0; 
        for (int i = 0; i < nums.length; i++){
	        if (nums[i] == 0){
                snowBallSize++; 
            }
            else if (snowBallSize > 0) {
                int insertion_index = i-snowBallSize;
	            nums[insertion_index] = nums[i];
	            nums[i] = 0;
            }
        }
        
        /*
        //WE ITERATE THROUGH THE ARRAY, MOVE NON ZERO ELEMENTS TO THE LEFT
        //NOW FOR THE REMAINING PLACES IN THE ARRAY, WE ADD ZEROES
        int nonzero_insert = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {//if its a non zero element
                nums[nonzero_insert] = nums[i];//insert it at correct insertion point
                nonzero_insert++;//update next insertion point
            }
        }
        //now all non zero elements are arranged at front of the list
        //from curr nonzero insert point to end of array, the previously displaces zeroes should be added
        while(nonzero_insert < nums.length) {
            nums[nonzero_insert] = 0;
            nonzero_insert++;
        }        
        //now array has all non zero elements at front and zeroes at end
        */
        
        /*
        //non optimal approach, for each 0 we find, move it to the end and shift all elements to left
        
        int i = 0;
        int end = nums.length-1;
        
        while(i < end) {
            if(nums[i] == 0) {
                for(int j = i + 1; j <= end; j++) {
                    nums[j-1] = nums[j];
                }
                System.out.println(end);
                nums[end] = 0;
                end--;
            } else {
                i++;
            }
        }
        */
    }
}
