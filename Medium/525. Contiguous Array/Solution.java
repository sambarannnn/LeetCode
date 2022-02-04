class Solution {
    public int findMaxLength(int[] nums) {
        int count = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == 0) {
                count -= 1;
            } else {
                count += 1;
            }
            if(map.containsKey(count)) {
                maxLen = Math.max(maxLen, (i-map.get(count)));
            } else {
                map.put(count, i);
            }
            
        }
        return maxLen;
    }
}
