class Solution {
    public int subarraySum(int[] nums, int k) {
        //https://www.youtube.com/watch?v=fFVZt-6sgyo
        int sum = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<Integer, Integer>();
        
        //prefixSum, freq of occurence of each sum
        int count = 0;
        for(int num : nums) {
            sum += num;
            if(prefixSum.containsKey(sum - k)) {
                count += prefixSum.get(sum-k);
            }
            if((sum - k) == 0) {
                count += 1;
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
