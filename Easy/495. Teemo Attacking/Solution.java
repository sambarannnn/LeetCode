class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        
        int total_duration = 0;
        
        for(int i = 0; i < timeSeries.length - 1; i++) {
            //check if next attack arrives before completetion of current attack
            // if(duration > timeSeries[i+1] - timeSeries[i])//in this case, we wont be able to add entire duration
            //     total_duration += timeSeries[i+1] - timeSeries[i];
            // else
            //     total_duration += duration;//we add complete duration
            
            //above if else can be written as
            total_duration += Math.min(timeSeries[i+1] - timeSeries[i], duration);
        }     
        //for last attack, there is no further attack, so we add the total duration for this attack
        total_duration += duration;
        return total_duration;
        
//         int sum = 0;
        
//         for(int i = 0; i < timeSeries.length; i++) {
//             if(i == 0 || timeSeries[i-1] + duration - 1 < timeSeries[i])
//                 sum += duration;
//             else{
//                 sum += timeSeries[i] - timeSeries[i-1];
//             }
//         }
//         return sum;
    }
}
