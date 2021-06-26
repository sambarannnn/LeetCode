class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        Queue<List<Integer>> permutations = new LinkedList<List<Integer>>();//to use as LIFO
        permutations.add(new ArrayList<Integer>());//initializing with empty list
        
        while(permutations.peek().size() != nums.length) {
            //linked hashset so that order of insertion is maintained
            //hashset will give us O(1) lookup
            HashSet<Integer> curr_permutation = new LinkedHashSet<Integer>(permutations.remove());
            //using list instead, gives us faster answer still
            //List<Integer> curr_permutation = permutations.remove();//to find permutations of each combination
            
            for(int i = 0; i < nums.length; i++) {
                
                if(curr_permutation.contains(nums[i]))//no duplicates
                    continue;
                
                List<Integer> temp = new ArrayList<Integer>(curr_permutation);
                
                //List<Integer> temp = new ArrayList<Integer>(curr_permutation);//so that original list doesn't get affected
                temp.add(nums[i]);//create permutation
                
                permutations.add(temp);//add at last
            }
        }
        return (List) permutations;
    }
}
