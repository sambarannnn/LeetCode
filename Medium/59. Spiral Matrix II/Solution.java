class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int num = 1;
        
        int r1 = 0;
        int r2 = matrix.length-1;
        int c1 = 0;
        int c2 = matrix[0].length-1;
        
        while(r1 <= r2 && c1 <= c2) {
            
            for(int i = c1; i <= c2; i++) {
                matrix[r1][i] = num++;
            }
            for(int i = r1+1; i <= r2; i++) {
                matrix[i][c2] = num++;
            }
            
            if(r1 < r2 && c1 < c2) {
                for(int i = c2 - 1; i >= c1; i--) {
                    matrix[r2][i] = num++;
                }
                for(int i = r2-1; i > r1; i--) {
                    matrix[i][c1] = num++;
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        
        return matrix;
    }
}
/*
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int r = 0;
        int c = 0;
        int dir = 1;//1 = right, left = -1, up = 2, down = -2
        int curr = 1;
        int max = n*n;
        fill(matrix, n, r, c, dir, curr, max);
        return matrix;
    }
    public static void fill(int[][] matrix, int n, int r, int c, int dir, int curr, int max) {
        if(curr > max) {
            return;
        }
        matrix[r][c] = curr;
        if(dir == 1) {
            if(c == n-1 || matrix[r][c+1] != 0) {
                fill(matrix, n, r+1, c, -2, curr+1, max);
            } else {
                fill(matrix, n, r, c+1, 1, curr+1, max);
            }
        } else if(dir == -2) {
            if(r == n-1 || matrix[r+1][c] != 0) {
                fill(matrix, n, r, c-1, -1, curr+1, max);
            } else {
                fill(matrix, n, r+1, c, -2, curr+1, max);
            }
        } else if(dir == -1) {
            if(c == 0 || matrix[r][c-1] != 0) {
                fill(matrix, n, r-1, c, 2, curr+1, max);
            } else {
                fill(matrix, n, r, c-1, -1, curr+1, max);
            }
        } else if(dir == 2) {
            if(r == 0 || matrix[r-1][c] != 0) {
                fill(matrix, n, r, c+1, 1, curr+1, max);
            } else {
                fill(matrix, n, r-1, c, 2, curr+1, max);
            }
        }
    }
}
*/
