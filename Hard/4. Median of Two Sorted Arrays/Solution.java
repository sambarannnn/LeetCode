class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 > len2) {
            //make sure nums1 has smaller length
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = len1;//to make a partition such that left has all elements and right has no elements
        
        while(low <= high) {
            int partitionX = (low+high)/2;
            //total length's mid - x partition
            //we are adding 1 to total length, so that we have one extra element in x
            int partitionY = (len1+len2+1)/2 - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = (partitionX == len1) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == len2) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //we have found the correct partition
                if((len1+len2) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightY, minRightX))/2.0;
                } else {
                    return (double) (Math.max(maxLeftX, maxLeftY));
                }
            }
            if(maxLeftX > minRightY) {
                //we are too far on right side for partitionX. Go on left side.
                high = partitionX-1;
            } else {
                //we have too less in first array
                low = partitionX+1;
            }
        }
        //only if input wasnt sorted in the first place
        return 0.0;
    }
}
