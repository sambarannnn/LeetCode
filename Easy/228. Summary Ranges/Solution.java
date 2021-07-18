class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res= new ArrayList<String>();
        for(int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while(i + 1 < nums.length && nums[i] + 1 == nums[i+1])
                i++;
            int end = nums[i];
            
            if(start != end) {
                res.add(start + "->" + end);
            } else {
                res.add(String.valueOf(start));
            }
        }
        return res;
    }
}
