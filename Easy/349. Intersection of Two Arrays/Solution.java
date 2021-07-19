class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> arrayOne = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();
        for(int i = 0; i < nums1.length; i++)
            arrayOne.add(nums1[i]);
        //arrayone has only unique elements of nums1
        for(int i = 0; i < nums2.length; i++) {
            //if we find an element which intersects with a value in arrayone, we add it to intersection, set addition ignores duplicates
            if(arrayOne.contains(nums2[i]))
                intersection.add(nums2[i]);
        }
        int[] result = new int[intersection.size()];
        int i = 0;
        for(int num : intersection) {
            result[i++] = num;
        }
        return result;
    }
}
