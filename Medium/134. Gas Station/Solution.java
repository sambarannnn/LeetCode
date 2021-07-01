class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        //if total cost is more than total gas, no solution
        //means, if (total gas) - (total cost) is negative, no soln
        int tank_difference = 0;
        for(int i = 0; i < gas.length; i++) {
            tank_difference += gas[i] - cost[i]; 
        }
        if(tank_difference < 0)
            return -1;
        
        int start_point = 0;
        int tank_value = 0;
        
        for(int i = 0; i < gas.length; i++) {
            
            int curr_change = gas[i] - cost[i];
            
            if(tank_value + curr_change < 0) {// we cannot start from here, move start ahead and reset tank_value
                //in case of finding negative change after finding a start point already
                ////we reset start to next one (ignoring all potential start points in the middle) since all middle elements will yield lesser accumulate value than the first starting element(as it was adding the first positive value)
                start_point = i + 1;//not start = start+1 since we skip all points in middle of start to i as they will still yield smaller value
                tank_value = 0;
            } else {
                tank_value += curr_change;
            }
            
        }
        return start_point;
    }
}
