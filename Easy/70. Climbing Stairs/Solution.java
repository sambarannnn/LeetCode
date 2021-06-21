class Solution {
    public int climbStairs(int n) {
        //for any stair at nth level, 
        //no of ways to reach that is either from previous level(1 stair) or from prev to previous level(2 stairs).
        //for 1 stair, only 1 way to climb that is w 1 step
        //for 2 stairs, 2 ways to climb i.e., 1+1(2steps) or 2(single step)
        //for nth stair no of possible ways = possible ways for (n-1) + possible ways for (n-2)
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        //imagine you are at step no 3(n = 3)
        int one_step_before = 2;//ways to reach step no 2
        int two_steps_before = 1;//ways to reach step no 1
        int all_ways = 0;
        
        for(int i=2; i<n; i++){
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }
}
