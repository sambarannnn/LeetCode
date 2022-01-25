class Solution {
    public boolean validMountainArray(int[] arr) {
        int peak = 0;
        int i = 0;
        while(i < arr.length-1 && arr[i] < arr[i+1]) {
            i++;
        }
        peak = i;
        if(peak == 0 || peak == arr.length-1)
            return false;
        while(i < arr.length-1 && arr[i] > arr[i+1]) {
            i++;
        }
        if(i != arr.length-1)
            return false;
        return true;
    }
}
