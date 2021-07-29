class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)//if obstacle is on starting position, we cant move ahead
            return 0;
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        //for any cells in row0 and col0, ways to reach is 1
        for(int i = 0; i < dp.length; i++) {
            if(obstacleGrid[i][0] != 1)
                dp[i][0] = 1;
            else {
                while(i < dp.length)//if theres any obstacle in ths path, all further ones cant be reached
                    dp[i++][0] = 0;
            }
        }
            
        for(int i = 0; i < dp[0].length; i++) {
            if(obstacleGrid[0][i] != 1)
                dp[0][i] = 1;
            else {
                while(i < dp[0].length)//if theres any obstacle in ths path, all further ones cant be reached
                    dp[0][i++] = 0;
            }
        }
        //fill the rest of the cells with ways to reach
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++)
                if(obstacleGrid[i][j] != 1)//we cannot reach obstacle cells
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
