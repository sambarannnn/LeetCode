class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length-1]-position[0];
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(isPossible(position, m, mid)) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high;

    }
    public static boolean isPossible(int[] position, int tot_balls, int min_force) {
        int curr_loc = position[0];
        int placed_balls = 1;
        
        for(int i = 1; i < position.length; i++) {
            if(position[i] - curr_loc >= min_force) {
                curr_loc = position[i];
                placed_balls++;
            }
            if(placed_balls == tot_balls) {
                return true;
            }
        }
        return false;
    }
}
