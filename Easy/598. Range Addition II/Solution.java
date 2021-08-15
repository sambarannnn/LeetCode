class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        //to find the bottom right of the overlapping area
        int row = m;
        int col = n;
        for(int[] op : ops) {
            row = Math.min(row, op[0]);
            col = Math.min(col, op[1]);
        }
        return row*col;
    }
}
