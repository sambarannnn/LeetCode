class Solution {
    private class Details {
        private int freq;
        private int first_index;
        
        public Details(int freq, int first_index) {
            this.freq = freq;
            this.first_index = first_index;
        }
    }
    public int findShortestSubArray(int[] nums) {
        //or use two separate hashmaps
        HashMap<Integer, Details> map = new HashMap<>();
        int res = 0;
        int degree = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            //filling details (frequency and first occurence index) of this num
            Details d = map.getOrDefault(num, new Details(0, i));//0 is default freq value
            d.freq++;//updating freq
            map.put(num, d);
            
            if(degree < map.get(num).freq) {//we have found new degree, this num has to be first and last index of our subarray
                degree = map.get(num).freq;
                res = i - map.get(num).first_index + 1;
            } else if(degree == map.get(num).freq) {//in case this one has a smaller subarray(left index(first_index) is nearer to right index(i))
                res = Math.min(res, i - map.get(num).first_index + 1);
            }
        }
        return res;
    }
}
