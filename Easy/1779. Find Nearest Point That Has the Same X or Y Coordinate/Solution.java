class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minManDist = Integer.MAX_VALUE;
        int res = -1;
        for(int i = 0; i < points.length; i++) {
            int xi = points[i][0];
            int yi = points[i][1];
            if(xi == x || yi == y) {
                int currManDist = Math.abs(xi - x) + Math.abs(yi - y);
                if(minManDist > currManDist) {
                    minManDist = currManDist;
                    res = i;
                }
            }
        }
        return res;
    }
}
