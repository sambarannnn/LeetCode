class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //we need to sort the input, so we can move over the equal elements
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int index, int target, ArrayList<Integer> current, List<List<Integer>> result) {
        if(target < 0)
            return;
        else if(target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        } else {
            for(int i = index; i < candidates.length; i++) {
                if(target < candidates[i])//removes unnecessary calculations
                    break;
                current.add(candidates[i]);
                //now, new target will be target-candidates[index]
                backtrack(candidates, i+1, target-candidates[i], current, result);
                //remove this previously added element
                current.remove(current.size() - 1);
                while(i < candidates.length-1 && candidates[i] == candidates[i+1])//skipping duplicates
                    i++;
            }
        }
    }
}
