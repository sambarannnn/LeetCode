class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //can use a hashset instead of arraylist (if you don't plan on checking for duplicates in every step) but keep in mind that hashset insertion is order of logn
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; i++) {
            int a = nums[i];
            for(int j = i+1 ; j < nums.length-2; j++) {
                int b = nums[j];
                
                int left = j + 1;
                int right = nums.length - 1;
                
                while(left < right) {
                    int c = nums[left];
                    int d = nums[right];
                    int sum = a + b + c + d;
                    
                    if(sum == target) {
                        res.add(new ArrayList(Arrays.asList(a, b, c, d)));
                        //to move pointers over duplicates ONLY WHEN WE FIND AN ANSWER
                        while(left < right && nums[left] == nums[left+1]) // skip same result
                            left++;
                        while(left < right && nums[right] == nums[right-1]) // skip same result
                            right--;
                        left++;
                        right--;
                    }
                    else if(sum < target)
                        left++;
                    else
                        right--;
                }
                while(j < nums.length-1 && nums[j] == nums[j+1])//skipping duplicates
                    j++;
            }
            while(i < nums.length-1 && nums[i] == nums[i+1])//skipping duplicates
                    i++;
        }
        return new ArrayList<>(res);
    }
}
