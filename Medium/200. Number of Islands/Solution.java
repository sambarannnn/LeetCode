class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    DFSMarkIslands(i, j, grid);
                }
            }
        }
        return count;
    }
    
    private void DFSMarkIslands(int row, int col, char[][] grid) {
        
        if(row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1)
            return;
        
        grid[row][col] = '*';//to mark this landmass as part of already counted in an island
        
        //if you have 1 below, move down
        if(row < grid.length - 1 && grid[row+1][col] == '1')
            DFSMarkIslands(row+1, col, grid);
        
        //go up if u have a 1 above
        if(row > 0 && grid[row-1][col] == '1')
            DFSMarkIslands(row-1, col, grid);
        
        //go right if you have a 1 at right
        if(col < grid[0].length - 1 && grid[row][col+1] == '1')
            DFSMarkIslands(row, col+1, grid);
        
        //go left if u have a 1 at left
        if(col > 0 && grid[row][col-1] == '1')
            DFSMarkIslands(row, col-1, grid);
    }
}
