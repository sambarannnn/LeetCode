class Solution {
    
    public int totalNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        int curr_row = 0;
        int count = 0;
        count += backtrack(n, chessBoard, curr_row, count);
        
        return count;
    }
    public int backtrack(int n, char[][] chessBoard, int curr_row, int count) {
        if(curr_row == n) {
            count++;
            return count;
        }
        for(int col = 0; col < n; col++) {
            if(isValid(chessBoard, curr_row, col)) {
                chessBoard[curr_row][col] = 'Q';
                count = backtrack(n, chessBoard, curr_row+1, count);
                chessBoard[curr_row][col] = '.';
            }
        }
        return count;
    }
    public boolean isValid(char[][] chessBoard, int row, int col) {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < chessBoard[i].length; j++) {
                if(chessBoard[i][j] == 'Q' && ((j == col) || (Math.abs(row-i) == Math.abs(col-j))))
                   return false;
            }
        }
        return true;
    }
}
