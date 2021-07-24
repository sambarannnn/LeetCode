class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);//maps index of every element
        }
        for(int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            int index = map.get(num);
            while(index < nums2.length) {
                if(nums2[index] > num) {
                    ans[i] = (nums2[index]);
                    break;
                } else if(index == nums2.length - 1)
                    ans[i] = (-1);
                index++;
            }
        }
        return ans;
    }
}
