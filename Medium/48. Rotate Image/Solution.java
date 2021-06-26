class Solution {
    public void rotate(int[][] matrix) {
        /*
        clockwise rotate
        * 
        1)first transpose (reverse) up to down, 
        2) then swap the symmetry (L-R)
        * 1 2 3     1 4 7     7 4 1
        * 4 5 6  => 2 5 8  => 8 5 2
        * 7 8 9     3 6 9     9 6 3
        
        FOR ANTI CLOCKWISE
        1) swap the symmetry (L-R)
        2) transpose
        * 1 2 3     3 2 1     3 6 9
        * 4 5 6  => 6 5 4  => 2 5 8
        * 7 8 9     9 8 7     1 4 7
        */
        //First Transpose the matrix
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        //transposing
        for(int i = 0; i < rows; i++) {
            for(int j = i; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //swapping symmetry
        for(int i = 0; i < rows; i++) {
            int left = 0;
            int right = cols-1;
            while(left <= right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
        
    }
}
