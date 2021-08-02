class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for(int n : nums) {
            int size = res.size();
            for(int i = 0; i < size; i++) {
                List<Integer> permutation = new ArrayList<>(res.get(i));//take out each existing permutation
                permutation.add(n);//add a new digit to it
                res.add(permutation);//add to result, this modified permutation
            }
        }
        return res;
    }
    //BACKTRACKING
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<List<Integer>>();
    //     backtrack(new ArrayList<>(), res, 0, nums);
    //     return res;
    // }
    // private void backtrack(List<Integer> curr, List<List<Integer>> res, int index, int[] nums){
    //     res.add(new ArrayList<Integer>(curr));
    //     if(index == nums.length)
    //         return;
    //     for(int i = index; i < nums.length; i++) {
    //         curr.add(nums[i]);
    //         backtrack(curr, res, i+1, nums);
    //         curr.remove(curr.size()-1);
    //     }
    // }
}
