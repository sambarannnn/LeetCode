class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //start from top right corner
        //if target is bigger than this value, you cant move left(since rows are sorted rightwards and if you move left you will find a smaller value), So you move down, as cols are sorted downwards and you will find a bigger value by moving downwards
        //if target is smaller than this value, then move leftwards
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(row <= matrix.length-1 && col >= 0) {
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] > target)
                col--;//rows sorted rightwards
            else if(matrix[row][col] < target)
                row++;//cols sorted downwards
        }
        return false;
    }
}
