class Solution {
    public int uniquePathsIII(int[][] grid) {
        int[] res = new int[]{0};
        int total = grid.length * grid[0].length;
        int r = -1, c = -1;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    r = i;
                    c = j;
                } else if(grid[i][j] == -1) {
                    total--;
                }
            }
        }
        //System.out.println(total);
        findPaths(r, c, 1, grid, res, total);
        return res[0];
    }
    public static void findPaths(int r, int c, int curr, int[][] grid, int[] res, int total) {
        
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] == -1 || grid[r][c] == -2) {
            return;
        }
        if(grid[r][c] == 2 && curr == total) {
            res[0]++;
            return;
        }
        if(grid[r][c] == 2) {
            return;
        }
        //System.out.println(r + " " + c);
        grid[r][c] = -2;
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for(int i = 0; i < dirs.length; i++) {
            int[] dir = dirs[i];
            findPaths(r+dir[0], c+dir[1], curr+1, grid, res, total);
        }
        grid[r][c] = 0;
    }
}
