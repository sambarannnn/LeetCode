class Solution {
    public int singleNumber(int[] nums) {
    /*
        if(nums.length == 1)
            return nums[0];
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i : nums) {
            //getOrDefault(Object key, V defaultValue) is used to get the value mapped with specified key. If no value is mapped with the provided key then the default value is returned.
                hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        //all other keys should have 2 as value
        for (int i : nums) {
            if (hm.get(i) == 1) 
                return i;
        }
        return -1;
    */
    //BITWISE XOR ( ^ ) :
    // IT GIVES 0 FOR SAME VALUES : N^N = 0
    // IT GIVEN N FOR N^0 : N^0 = N
    // THUS IF WE APPLY BITWISE XOR TO ALL ELEMENTS OF THE GIVEN ARRAY
    // ALL THE EQUAL VALUE PAIRS SHOULD COMPUTE TO 0.
    // THE REMAINING UNIQUE ELEMENT XOR WITH 0 WILL GIVE THAT UNIQUE ELEMENT
    // Time complexity : O(N)
        int xor = 0;
        for(int i : nums) {
            xor = xor^i;
        }
        return xor;
    }
}
