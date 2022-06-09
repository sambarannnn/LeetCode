class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        //we know that input is sorted
        //so we can have two pointers at both ends
        int left = 0;
        int right = numbers.length-1;
        
        while(left <= right) {
            if(numbers[left] + numbers[right] == target) {
                ans[0] = left+1;
                ans[1] = right+1;
                return ans;
            } else if(numbers[left] + numbers[right] < target) {//move left pointers rightward
                left++;
            } else {
                right--;
            }
        }
        return ans;
        //O(N)
        // number, index
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for(int i = 0; i < numbers.length; i++) {
        //     int element = numbers[i];
        //     //check if it's complement exists in the hashmap
        //     int complement = target - numbers[i];
        //     if(map.containsKey(complement)) {
        //         ans[0] = map.get(complement);
        //         ans[1] = i + 1;
        //         return ans;
        //     } else {
        //         map.put(numbers[i], i+1);
        //     }
        // }
        // return ans;
    }
}
