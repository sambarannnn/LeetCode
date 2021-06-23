class Solution {
    
    public boolean containsDuplicate(int[] nums) {
        //we can also sort and check but that would be nlogn approach as sorting is nlogn plus another O(n) for iterating through the sorted array checking for equal adjacent elements
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public boolean HASHcontainsDuplicate(int[] nums) {
        
        
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
