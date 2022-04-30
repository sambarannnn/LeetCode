class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int total = m*n;
        int[][] grid = new int[m][n];
        for(int i = 0; i < walls.length; i++) {
            int[] wall = walls[i];
            grid[wall[0]][wall[1]] = 1;
        }
        for(int i = 0; i < guards.length; i++) {
            int[] guard = guards[i];
            grid[guard[0]][guard[1]] = 3;
        }
        int count = walls.length + guards.length;
        for(int ind = 0; ind < guards.length; ind++) {
            int[] guard = guards[ind];
            int r = guard[0];
            int c = guard[1];
            for(int i = r+1; i < grid.length; i++) {
                if(grid[i][c] == 1 || grid[i][c] == 3) {
                    break;
                }
                if(grid[i][c] == 0) count++;
                grid[i][c] = 2;
            }
            for(int i = r-1; i >= 0; i--) {
                if(grid[i][c] == 1 || grid[i][c] == 3) {
                    break;
                }
                if(grid[i][c] == 0) count++;
                grid[i][c] = 2;
            }
            for(int j = c+1; j < grid[r].length; j++) {
                if(grid[r][j] == 1 || grid[r][j] == 3) {
                    break;
                }
                if(grid[r][j] == 0) count++;
                grid[r][j] = 2;
            }
            for(int j = c-1; j >= 0; j--) {
                if(grid[r][j] == 1 || grid[r][j] == 3) {
                    break;
                }
                if(grid[r][j] == 0) count++;
                grid[r][j] = 2;
            }
        }
        return m*n - count;
    }
}
