class Solution {
    public int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length-1);
    }
    public int sort(int[] nums, int low, int high) {
        if(low == high)
            return 0;
        int rev = 0;
        if(low < high) {
            int mid = low + (high-low)/2;
            rev += sort(nums, low, mid);
            rev += sort(nums, mid+1, high);
            rev += merge(nums, low, mid, high);
        }
        return rev;
    }
    public int merge(int[] nums, int low, int mid, int high) {
        int count = calculate(nums, low, mid, high);
        int n1 = mid-low+1;
        int n2 = high-mid+1-1;
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for(int i = 0; i < n1; i++) {
            L[i] = nums[low+i];
        }
        for(int j = 0; j < n2; j++) {
            R[j] = nums[mid+1+j];
        }
        int i = 0, j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k++] = L[i++];
            } else {
                nums[k++] = R[j++];
            }
        }

        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }
  
        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
        return count;
    }
    public int calculate(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid+1;
        int count = 0;
        for(i = low; i <= mid; i++) {
            while((j <= high) && (nums[i]/2.0 > nums[j])) {
                j++;
            }
            count += j-(mid+1);
        }
        return count;
    }
}
