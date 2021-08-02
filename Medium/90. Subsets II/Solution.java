class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        int start_index = 0;
        for(int i = 0; i < nums.length; i++) {
            int size = res.size();

            for(int j = start_index; j < size; j++) {
                List<Integer> permutation = new ArrayList<>(res.get(j));
                permutation.add(nums[i]);
                res.add(permutation);
            }
            if(i<nums.length-1 && nums[i] == nums[i+1])
                start_index = size;//at the last inserted position in res
            else
                start_index = 0;
        }
        return res;
    }
    // BACKTRACKING
    // public List<List<Integer>> subsetsWithDup(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<List<Integer>>();
    //     Arrays.sort(nums);
    //     backtrack(res, new ArrayList<>(), 0, nums);
    //     return res;
    // }
    // private void backtrack(List<List<Integer>> res, List<Integer> curr, int index, int[] nums) {
    //     res.add(new ArrayList<>(curr));
    //     if(index == nums.length)
    //         return;
    //     for(int i = index; i < nums.length; i++) {
    //         curr.add(nums[i]);
    //         backtrack(res, curr, i+1, nums);
    //         curr.remove(curr.size()-1);
    //         while(i < nums.length - 1 && nums[i] == nums[i+1])//skipping duplicates
    //             i++;
    //     }
    // }
}
