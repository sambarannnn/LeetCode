class Solution {
    public int brokenCalc(int startValue, int target) {
        //calculate target to startValue
        //top to bottom will be deterministic as we have only one path to go i.e. downwards
        //divide as many times as u can to get the most optimal smaller no.
        //from here just add +1 to reach startvalue
        int steps = 0;
        while(target > startValue) {
            if(target % 2 == 0) {
                target /= 2;
            } else {
                target++;
            }
            steps++;
        }
        steps += startValue - target;
        return steps;
    }
}
