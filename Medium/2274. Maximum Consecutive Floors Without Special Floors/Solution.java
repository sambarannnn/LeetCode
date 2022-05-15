class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int max = Integer.MIN_VALUE;
        int curr = 0;
        int left = bottom;
        curr = special[0] - left;//first gap
        max = Math.max(curr, max);
        for(int i = 1; i < special.length; i++) {
            curr = special[i] - special[i-1] - 1;//all mid gaps
            // System.out.println(curr);
            max = Math.max(curr, max);
            left = curr;
        }
        int right = top;
        curr = right - special[special.length-1];//last gap
        //System.out.println(curr);
        max = Math.max(curr, max);
        return max;
    }
}
