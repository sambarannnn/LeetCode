class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[][] res = new int[grid.length][grid[0].length];
        
        int count = grid.length * grid[0].length;
        int width = grid[0].length;
        for(int i = 0; i < count; i++) {
            // row    = i / width;
            // column = i % width;
            //OR row = i % height; col = i / height
            int newPos = (i + k) % count;
            int r = newPos / width;
            int c = newPos % width;
            // System.out.println(i/width + " | " + i%width + " ==> " + r + " | " + c);
            res[r][c] = grid[i/width][i%width];
        }
        
        return (List)Arrays.asList(res);                 
    }
}
