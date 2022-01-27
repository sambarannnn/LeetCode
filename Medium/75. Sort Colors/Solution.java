class Solution {
    public void sortColors(int[] nums) {
        //DUTCH NATIONAL FLAG ALGO
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        
        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else if(nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
        
    }
    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
// class Solution {
//     public void sortColors(int[] nums) {
//         //count the number of 0s, 1s and 2s
//         //put 0s first, then 1s then 2s
//         int freq0 = 0;
//         int freq1 = 0;
//         int freq2 = 0;
//         for(int num : nums) {
//             if(num == 0)
//                 freq0++;
//             else if(num == 1)
//                 freq1++;
//             else
//                 freq2++;
//         }
//         int index = 0;
//         while(freq0-- > 0)
//             nums[index++] = 0;
//         while(freq1-- > 0)
//             nums[index++] = 1;
//         while(freq2-- > 0)
//             nums[index++] = 2;
//     }
// }
