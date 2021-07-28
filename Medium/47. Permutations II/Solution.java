class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);//to move over duplicates
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(nums, new boolean[nums.length], 0, new ArrayList<Integer>(), result);
        return result;
    }
    private void backtrack(int[] nums, boolean[] visited_indexes, int index, List<Integer> current, List<List<Integer>> result) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!visited_indexes[i]) {
                current.add(nums[i]);
                visited_indexes[i] = true;
                backtrack(nums, visited_indexes, i+1, current, result);
                current.remove(current.size() - 1);
                visited_indexes[i] = false;
                while(i< nums.length-1 && nums[i] == nums[i+1])//move over duplicates
                    i++;
            }
        }
    }
}
