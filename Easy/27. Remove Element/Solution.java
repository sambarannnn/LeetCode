class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        //j is slow, i is fast
        //j is used to place the safe(unequal to value) elements at the left of the array
        //i progresses forward scanning the elements
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
