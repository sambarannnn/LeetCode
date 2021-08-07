class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //to create a lower row beneath triangle's lowest row 
        //automatically filled with zeroes
        //for the bottom row, the values will be 0
        int[] optimal_dp = new int[triangle.get(triangle.size()-1).size()+1];
       //from bottom of triangle to apex
        for(int i = triangle.size()-1; i >= 0; i--) {
            //for each element in the row,
            for(int j = 0; j < triangle.get(i).size(); j++) {
                //min sum will be sum of curr element + element in the lower row at same index or +1 index (to the left or right)
                optimal_dp[j] = triangle.get(i).get(j) + Math.min(optimal_dp[j], optimal_dp[j+1]);
            }
        }
        return optimal_dp[0];
    }
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     return DFS(triangle, 0, 0, new Integer[triangle.size()][triangle.get(triangle.size()-1).size()]);
    // }
    // private int DFS(List<List<Integer>> triangle, int row, int col, Integer[][] memo) {
    //     if(row == triangle.size()) {
    //         return 0;
    //     }
    //     if(memo[row][col] != null) {
    //         return memo[row][col];
    //     }
    //     int min_sum = Math.min(DFS(triangle, row+1, col, memo), DFS(triangle, row+1, col+1, memo));
    //     int path_sum = min_sum + triangle.get(row).get(col);
    //     memo[row][col] = path_sum;
    //     return path_sum;
    // }
}

