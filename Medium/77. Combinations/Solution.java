class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new ArrayList());
        return res;
    }
    private void backtrack(int index, int n, int k, List<Integer> curr){
        if(curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i <= n; i++) {
            curr.add(i);//when we are at (index = last number), we add last number and send to backtrack, next index doesn't satisfy loop and it just comes back
            backtrack(i+1, n, k, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
