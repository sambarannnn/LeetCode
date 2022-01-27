class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int prev = -1;
        while(i < nums1.length && j < nums2.length) {
            if(prev == nums1[i]) i++;
            else if(prev == nums2[j]) j++;
            else if(nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                prev = nums1[i];
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            }
        }
        int[] ints = new int[res.size()];
        int k = 0;
        for (Integer n : res) {
            ints[k++] = n;
        }
        return ints;
    }
}
// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {
//         HashSet<Integer> arrayOne = new HashSet<>();
//         HashSet<Integer> intersection = new HashSet<>();
//         for(int i = 0; i < nums1.length; i++)
//             arrayOne.add(nums1[i]);
//         //arrayone has only unique elements of nums1
//         for(int i = 0; i < nums2.length; i++) {
//             //if we find an element which intersects with a value in arrayone, we add it to intersection, set addition ignores duplicates
//             if(arrayOne.contains(nums2[i]))
//                 intersection.add(nums2[i]);
//         }
//         int[] result = new int[intersection.size()];
//         int i = 0;
//         for(int num : intersection) {
//             result[i++] = num;
//         }
//         return result;
//     }
// }
