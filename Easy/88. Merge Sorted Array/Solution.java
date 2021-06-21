class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //take 2 pointers at last digits of the 2 lists
        int i = m-1;
        int j = n-1;
        //take a pointer at extreme last (blank area) of 1st list
        int k = m + n -1;
        //starting from far right, put the greatest elements to the right of the list
        //(start by occupying the blank spaces)
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        //in case elements in 2nd list are yet to be placed
        //loop enters if i becomes negative before j
       while(j >= 0) {
           nums1[k--] = nums2[j--];
        }   
    }
}
