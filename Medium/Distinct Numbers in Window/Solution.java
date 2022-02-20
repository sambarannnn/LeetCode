public class Solution {
    public int[] dNums(int[] nums, int k) {
        HashMap<Integer, Integer> freq_map = new HashMap<Integer, Integer>();
        int[] ans = new int[nums.length-k+1];
        int i = 0;
        int j = 0;
        while(j < nums.length) {
            freq_map.put(nums[j], freq_map.getOrDefault(nums[j], 0) +1 );
            if(j-i+1 == k) {
                ans[i] = freq_map.size();
                int new_freq = freq_map.get(nums[i]) - 1;
                if(new_freq == 0) {
                    freq_map.remove(nums[i]);
                } else {
                    freq_map.put(nums[i], new_freq);
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}
