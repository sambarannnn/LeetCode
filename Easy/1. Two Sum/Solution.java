import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //using hashtable or hashmap to have O(1) access to elements
        Hashtable<Integer,Integer> hm = new Hashtable<Integer,Integer>();
        int complement;
        int[] ans = new int[2];
        //iterate over the array and for each element check if complement is present, if yes then return out of function w ur answer. Else, add element to hashtable and continue forward
        for(int i = 0; i < nums.length; i++) {//O(n)
            complement = target - nums[i];
            if(hm.containsKey(complement)) {//each lookup is only O(1) time
                ans[0] = hm.get(complement);//we need the index value of complement
                ans[1] = i;//current index
                return ans;
            }
            hm.put(nums[i], i);//takes key as the number and value as its index
        }
        return ans;
    }
}
