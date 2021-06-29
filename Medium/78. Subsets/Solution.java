class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        //adding first empty subset
        result.add(new ArrayList<Integer>());
        
        //for each element in the set
        for(int num : nums) {
            int size = result.size();//tells us abt no of permutations in the result
            
            for(int i = 0; i < size; i++) {//for each permutation
                List<Integer> permutation = new ArrayList<Integer>(result.get(i));//adding curr permutation(which is a list of integers)
                //permutation.addAll(result.get(i));//adding curr permutation(which is a list of integers)
                permutation.add(num);//making new permutation
                
                result.add(permutation);//adding new permutation to result list
            }
        }
        return result;
    }
}
