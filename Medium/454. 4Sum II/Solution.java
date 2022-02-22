class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> freq_sum = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                freq_sum.put(nums1[i] + nums2[j], freq_sum.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        int count = 0;
        for(int k = 0; k < nums3.length; k++) {
            for(int l = 0; l < nums4.length; l++) {
                count += freq_sum.getOrDefault((-1) * (nums3[k] + nums4[l]), 0);
            }
        }
        return count;
    }
}
