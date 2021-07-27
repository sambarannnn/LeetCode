class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //we can speed up the backtracking by using a sorted array
        //in this way, when the current candidate element becomes bigger than the target, no point in checking further candidates
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }
    private void backtrack(int[] candidates, int index, int target, ArrayList<Integer> current, List<List<Integer>> result) {
        if(target == 0){
            //we have found a proper combination
            result.add(new ArrayList<Integer>(current));//we create a copy of current and add it to result
            //we dont add the current list itself as it is a reference variable, and willlater be updated in further course of the backtracking
            return;
        } else if(target < 0) {//we have added too big a number, reject
            return;
        } else {
            //traverse the entire candidates list and pick each and every one and check it's possibility
            for(int i = index; i < candidates.length; i++) {
                //IF STATEMENT ONLY FOR SORTED ARRAY INPUT
                if(target < candidates[i])//at any point, if the target becomes smaller that this candidate, all further candidates are bigger so the target will always be smaller, so it doesnt make sense to check further, so we break
                    break;
                current.add(candidates[i]);
                //now, new target will be target-candidates[index]
                backtrack(candidates, i, target-candidates[i], current, result);
                //remove this previously added element
                current.remove(current.size() - 1);
            }
        }
    }
}
