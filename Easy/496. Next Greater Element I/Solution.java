class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //we can use a stack to find the next greater element
        //we store every number/or every decreasing sequence in a stack
        //when we find a number bigger than the top of the stack
        //this number will be the next greatest element for the top element of the stack, so we keep popping until the top element is smaller than the current element
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for(int num : nums2) {
            //before pushing, check if the curr number is bigger
            while(!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            //just push the number into the stack
            stack.push(num);
        }
        //now we have the nges of all the elements in nums2
        //lets use the ones we need, for the elements present in nums1
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
        // int[] ans = new int[nums1.length];
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for(int i = 0; i < nums2.length; i++) {
        //     map.put(nums2[i], i);//maps index of every element
        // }
        // for(int i = 0; i < nums1.length; i++) {
        //     int num = nums1[i];
        //     int index = map.get(num);//we start to find next greater element from this index
        //     while(index < nums2.length) {
        //         if(nums2[index] > num) {
        //             ans[i] = (nums2[index]);
        //             break;
        //         } else if(index == nums2.length - 1)
        //             ans[i] = (-1);
        //         index++;
        //     }
        // }
        // return ans;
    }
}
