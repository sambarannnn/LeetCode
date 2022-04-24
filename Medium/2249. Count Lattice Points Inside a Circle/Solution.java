class Solution {
    public int countLatticePoints(int[][] circles) {
        //for each circle, check all the lattice points and check which lie inside the circle
        //common points between multiple circles will be ignored
        HashSet<String> set = new HashSet<String>();
        for(int[] circle : circles) {
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];
            
            for(int cx = x-r; cx <= x+r; cx++) {
                for(int cy = y-r; cy <= y+r; cy++) {
                    int dx = x-cx;
                    int dy = y-cy;
                    if(dx*dx + dy*dy <= r*r) {
                        set.add(String.valueOf(cx) + ", " + String.valueOf(cy));
                    }
                }
            }
        }
        return set.size();
    }
}
