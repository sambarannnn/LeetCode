class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;//min one product, of 1 quantity (acc to constraints)
        int high = 0;
        for(int quantity : quantities) {
            high = Math.max(high, quantity);
        }//prod of max quantity
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(isPossible(n, quantities, mid)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
    public static boolean isPossible(int max_stores, int[] quantities, int max_quantity) {
        int stores_count = 0;
        
        for(int i = 0; i < quantities.length; i++) {
            stores_count += Math.ceil((double)quantities[i]/max_quantity);
            if(stores_count > max_stores) {
                return false;
            }
        }
        return true;
        
    }
}
