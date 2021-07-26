class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //To brute force the result, we can simply write 3 loops to iterate over all the triplets and check if each of them sums up to 0. Apparent, this will give us O(N^3) solution, which is not optimal.
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums.length < 3)
            return res;
        
        //let’s sort the array first. Now if we fix one number X in the array, the problem becomes finding 2 numbers that sum up to -X(if i+j+k = 0, j+k = -i) 
        //lets sort the array
        Arrays.sort(nums);
        
        //we can iterate over each number and inside the loop, solve the sub-problem as 2sum. To calculate the time complexity, sorting is O(NlogN), the outside loop is O(N) and the inside 2sum is O(N). Therefore, the overall time complexity is O(N^2) and space complexity is O(1).

        for(int i = 0; i < nums.length -2; i++) {
            //Since the array is sorted there won't be any chance the next entries sum to 0.
            if (nums[i] > 0) 
                break;
            if(i == 0 || nums[i-1] != nums[i]) { // skip same result, no duplicate triplets
                int p1 = i + 1;//so we don't calculate literally all combinations, we want i < j < k
                int p2 = nums.length - 1;
                int sum = 0 - nums[i];
                
                //we have 2 pointers at two ends of the array
                //lets try to find combinations
                while(p1 < p2) {
                    if(nums[p1] + nums[p2] == sum) {
                        res.add(new ArrayList<Integer>());
                        res.get(res.size() - 1).add(nums[i]);
                        res.get(res.size() - 1).add(nums[p1]);
                        res.get(res.size() - 1).add(nums[p2]);
                        //to move pointers over duplicates
                        while(p1 < p2 && nums[p1] == nums[p1+1]) // skip same result
                            p1++;
                        while(p1 < p2 && nums[p2] == nums[p2-1]) // skip same result
                            p2--;
                        p1++;
                        p2--;
                    }
                    else if(nums[p1] + nums[p2] < sum)
                        p1++;
                    else if (nums[p1] + nums[p2] > sum)
                        p2--;
                }
            }
        }
        return res;
    }
}
