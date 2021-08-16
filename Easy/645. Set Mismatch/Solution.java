public class Solution {
    public int[] findErrorNums(int[] nums) {
        // Arrays.sort(nums);
        // int[] res = new int[2];
        // res[0] = 0;
        // res[1] = 1;
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] == nums[i - 1])
        //         res[0] = nums[i];
        //     else if (nums[i] > nums[i - 1] + 1)
        //         res[1] = nums[i - 1] + 1;
        // }
        // res[1] = nums[nums.length - 1] != nums.length ? nums.length : res[1];
        // return res;
        
        // Map < Integer, Integer > map = new HashMap();
        // int dup = 0, missing = 0;
        // for (int n: nums) {
        //     map.put(n, map.getOrDefault(n, 0) + 1);
        // }
        // for (int i = 1; i <= nums.length; i++) {
        //     if (map.containsKey(i)) {
        //         if (map.get(i) == 2)
        //             dup = i;
        //     } else
        //         missing = i;
        // }
        // return new int[]{dup, missing};
        
        //all elements are 1-n
        
        int dup = 0;
        int missing = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            //if this number has already been turned negative
            if(nums[num-1] < 0)
                dup = num;
            else
                nums[num-1] *= -1;
        }
        //all elemenets will be negative now except the one whos index value is not present in the array
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                missing = i+1;
                break;
            }
        }
        return new int[]{dup, missing};
    }
}

