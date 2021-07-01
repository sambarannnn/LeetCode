class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        //add all numbers in a hashset for faster lookup of predecessors and successor
        
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }

        //iterate over every element in set
        //if the set does not contain any predecessor, then try to find as many successors as possible for maximum streak
        
        int maxstreak = 1;
        for(int n : set) {
            
            if(!set.contains(n-1)) {
                
                int curr = n;
                int streak = 1;
                
                while(set.contains(curr + 1)) {
                    curr++;
                    streak++;
                }
                maxstreak = Math.max(maxstreak, streak);
            }
        }
        return maxstreak;
        
        /*
        //nlogn
        //sort and find max consecutive length
        if(nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int currstreak = 1;
        int maxstreak = 1;
        for(int i = 1; i < nums.length; i++) {
            
            if(nums[i] != nums[i-1]) {//skiping duplicates
                
                if(nums[i] == nums[i-1] + 1)
                    currstreak++;
                else 
                    currstreak = 1;//resetting
            }
            maxstreak = Math.max(maxstreak, currstreak);
        }
        return maxstreak;
        */
    }
}
