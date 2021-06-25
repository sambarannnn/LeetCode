import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        //generic method
        if(nums == null)
	    		return null;
        
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        //since sorting will change the index order
        Arrays.sort(nums);
        int p1 = 0;
        int p2 = nums.length - 1;
        int a = 0;
        int b = 0;
        while(p1 < p2) {
            if(nums[p1] + nums[p2] == target) {
                a = nums[p1];
                b = nums[p2];
                break;
            } else if(p1 < p2 && nums[p1] + nums[p2] < target) {
                p1++;
            } else if(p1 < p2 && nums[p1] + nums[p2] > target) {
                p2--;
            }
        }
        int[] res = new int[2];
        
        for(int i = 0; i < nums2.length; i++){
	    	if(nums2[i] == a){
	    		res[0] = i;
				break;
    		}
	    }
        //System.out.println(a +"\n"+ b);
        //for target 6, if we had 3,3; we would need to find index of 2d occurence
        if(a != b){
	    		for(int i = 0; i < nums2.length; i++){
		    		if(nums2[i] == b){
		    			res[1] = i;
		    			break;
		    		}
		    	}
	    } else {
            for(int i = 0; i < nums2.length; i++){
				if(nums2[i] == b && i != res[0]){
	    			res[1] = i;
	    			break;
                }
		    }
        }
        return res;
        */
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
