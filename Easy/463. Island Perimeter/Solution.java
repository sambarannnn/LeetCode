class Solution {
    public int islandPerimeter(int[][] grid) {
        int edge_count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    edge_count += 4;//for curr square
                    if(i > 0 && grid[i-1][j] == 1)//has a neighbour in upper row
                        edge_count -= 2;//subtract 1 for each square's adjacent edge
                    if(j > 0 && grid[i][j-1] == 1)
                        edge_count -= 2;
                }
            }
        }
        return edge_count;
    }
}
