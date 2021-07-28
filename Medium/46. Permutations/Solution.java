class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(nums, new boolean[nums.length], new ArrayList<Integer>(), result);
        return result;
    }
    private void backtrack(int[] nums, boolean[] visited_indexes, List<Integer> current, List<List<Integer>> result) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!visited_indexes[i]) {
                current.add(nums[i]);
                visited_indexes[i] = true;
                backtrack(nums, visited_indexes, current, result);
                current.remove(current.size() - 1);
                visited_indexes[i] = false;
            }
        }
    }
}
