class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //slowest speed for koko = 1 banana per hour
        //highest speed = max of piles bananas per hour
        int low = 1;
        int high = 1;
        for(int bananas: piles) {
            high = Math.max(bananas, high);
        }
        //find first occurence of valid speed
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(isValid(piles, mid, h)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
    public static boolean isValid(int[] piles, int curr_speed, int tot_hours) {
        int hours_spent = 0;
        for(int i = 0; i < piles.length; i++) {
            hours_spent += Math.ceil((double)piles[i]/curr_speed);
            if(hours_spent > tot_hours)
                return false;
        }
        return true;
        
    }
}
