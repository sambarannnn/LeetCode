class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //only max 2 elements can be majority above n/3
        //use boyce moore's algorithm
        int cand1 = -1;
        int cand2 = -1;
        int c1 = 0;
        int c2 = 0;
        
        for(int num : nums) {
            if(num == cand1) {
                c1++;
            } else if(num == cand2) {
                c2++;
            } else if(c1 == 0) {
                cand1 = num;
                c1 = 1;
            } else if(c2 == 0) {
                cand2 = num;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        
        int f1 = 0;
        int f2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(cand1 == nums[i])
                f1++;
            else if(cand2 == nums[i])
                f2++;
        }

        List<Integer> res = new ArrayList<Integer>();
        if(f1 > nums.length/3)
            res.add(cand1);
        if(f2 > nums.length/3)
            res.add(cand2);
        
        return res;
    }
}
