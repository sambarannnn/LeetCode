class Solution {
    public boolean containsDuplicate(int[] nums) {
        //we can also sort and check but that would be nlogn approach as sorting is nlogn plus another O(n) for iterating through the sorted array checking for equal adjacent elements
        
        //O(N)
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) 
                return true;
            set.add(x);
        }
        return false;
    }
}
