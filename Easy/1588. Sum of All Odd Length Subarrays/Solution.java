class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        //https://www.youtube.com/watch?v=J5IIH35EBVE
        //calculate number of subarrays a particular index will be part of
        //half of these subarrays will be of odd length
        //so multiply the no of subarrays by this number to get total sum contribution of this number
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            int countEnd = i + 1;
            int countStart = arr.length - i;
            int totalSubarrays = countEnd * countStart;
            //ONE EXTRA ODD IF TOTAL NO OF SUBARRAYS ARE ODD
            int oddSubarrayCount = (totalSubarrays % 2 == 0) ? (totalSubarrays / 2) : (totalSubarrays / 2) + 1;
            sum += arr[i] * oddSubarrayCount;
        }
        return sum;
        //BRUTE FORCE SOLN
        // int res = 0
        // for(int i = 0; i < arr.length; i++) {
        //     for(int j = i; j < arr.length; j++) {
        //         if((i+j) % 2 == 0) {//odd length
        //             int currSum = 0;
        //             for(int k = i; k <= j; k++) {
        //                 currSum += arr[k];
        //             }
        //             res+=currSum;
        //         }
        //     }
        // }
        // return res;
    }
}
