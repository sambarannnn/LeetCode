class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length, sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += mat[i][i] + mat[i][n - 1 - i]; 
        }
        sum -=  n % 2 == 1 ? mat[n / 2][n / 2] : 0;//in case of odd number of rows n columns, subtract middle element
        return sum;        
    }
}
