class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //indexes are 0 - n-1
        //elements are 1 - n
        //so there is an index for every element
        //so for every element we find, we will negate it's corresponding index
        //after that, indexes with positive values have their corresponding elements missing
        
        for(int i = 0; i < nums.length; i++) {
            int index = nums[i];//we have an element for this index
            
            //ensure that the index hasn't already been negated
            if((nums[Math.abs(index) - 1]) > 0) {
                //index-1 since for element 1, index will be 0, for element 2, index will be 1 and so forth
                nums[Math.abs(index) - 1] = -1 * nums[Math.abs(index) - 1];
            }
        }
        
        List<Integer> res = new ArrayList<Integer>();
        for(int j = 1; j <= nums.length; j++) {
            if(nums[j-1] > 0)//not negated
                res.add(j);
        }
        return res;
        // using extra space
        // int[] map = new int[nums.length+1];
        // for(int num : nums) {
        //     map[num]++;
        // }
        // List<Integer> res = new ArrayList<Integer>();
        // for(int i = 1; i < map.length; i++) {
        //     if(map[i] == 0)
        //         res.add(i);
        // }
        // return res;
    }
}
