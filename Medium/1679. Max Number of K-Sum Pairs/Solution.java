class Solution {
    public int maxOperations(int[] nums, int k) {
        // O(NLOGN) but no extra space!
        // Arrays.sort(nums);
        // int i = 0;
        // int j = nums.length-1;
        // int count = 0;
        // while(i < j) {
        //     int sum = nums[i] + nums[j];
        //     if(sum == k) {
        //         count++;
        //         i++;
        //         j--;
        //     } else if(sum < k) {
        //         i++;
        //     } else {
        //         j--;
        //     }
        // }
        // return count;
        //O(N) but uses extra space
        HashMap<Integer, Integer> freq_map = new HashMap<>();
        int count = 0;
        for(int num : nums) {
            int complement = k - num;
            if(freq_map.containsKey(complement)) {
                count++;
                freq_map.put(complement, freq_map.get(complement)-1);
                if(freq_map.get(complement) == 0) {
                    freq_map.remove(complement);
                }
            } else {
                freq_map.put(num, freq_map.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
}
