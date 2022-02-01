class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        
        
        char[][] chessboard = new char[n][n];
        for (char[] row: chessboard)
            Arrays.fill(row, '.');//initializing board
        int curr_row = 0;
        backtracking(n, curr_row, chessboard, res);
        return res;
    }
    public void backtracking(int n, int curr_row, char[][] chessboard, List<List<String>> res) {
        if(curr_row == n) {
            // System.out.println("REACHED!!");
            res.add(screenshotChessboard(chessboard));
            return;
        }
        for(int col = 0; col < n; col++) {
            if(blocked(chessboard, curr_row, col) != true) {//if current position is VALID
                // System.out.println(curr_row +" " +col);
                chessboard[curr_row][col] = 'Q';
                backtracking(n, curr_row+1, chessboard, res);
                chessboard[curr_row][col] = '.';
            }
        }
    }
    public boolean blocked(char[][] chessboard, int r, int c) {
        //iterate from first to curr's above row to check if the queens above it can kill it
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < chessboard[r].length; j++) {
                if(chessboard[i][j] == 'Q' && ((j==c) || (Math.abs(i-r) == Math.abs(j-c))))
                    //if you find a queen, is it right above current ||| if its diagonally placed
                   return true;//kill it
            }
        }
        return false;
    }
    public List<String> screenshotChessboard(char[][] chessboard) {
        //just convert checcboard into list of strings rowwise and return
        List<String> currBoard = new ArrayList<String>();
        for(int i = 0; i < chessboard.length; i++) {
            currBoard.add(String.valueOf(chessboard[i]));
        }
        return currBoard;
    }
}
