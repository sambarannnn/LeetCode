class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> uniqueCandiesSet = new HashSet<>();
        for (int candy: candyType) {
            uniqueCandiesSet.add(candy);
        }
        // Then, find the answer in the same way as before.
        return Math.min(uniqueCandiesSet.size(), candyType.length / 2);
        // Arrays.sort(candyType);
        // int unique = 0;
        // for(int i = 0; i < candyType.length; i++) {
        //     unique++;
        //     while(i+1 < candyType.length && candyType[i] == candyType[i+1])
        //         i++;
        // }
        // return Math.min(unique, candyType.length/2);
    }
}
