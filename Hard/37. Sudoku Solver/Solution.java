class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    

    public boolean solve(char[][] board, int curr_row, int curr_col){
        if(curr_col == 9) {
            return solve(board, curr_row+1, 0);
        }
        if(curr_row == 9) {
            return true;
        }
        if(board[curr_row][curr_col] != '.') {
            return solve(board, curr_row, curr_col+1);
        }

        
        for(char x = '1'; x <= '9'; x++) {
            if(isValid(board, x, curr_row, curr_col)) {
                board[curr_row][curr_col] = x;
                if(solve(board, curr_row, curr_col+1)) {
                    return true;// without return here, the board reverts to initial state
                } 
                board[curr_row][curr_col] = '.';
            }
        }
        //reached here means this permutation aint right, backtrack with false
        return false;
    }
    
    public boolean isValid(char[][] board, char x, int r, int c) {
        //row check
        for(int i = 0; i < 9; i++) 
		    if(board[i][c] == x) 
			    return false;
	    // col check
        for(int i = 0; i < 9; i++) 
		    if(board[r][i] == x) 
			    return false;
        //3x3 box check
        int x0 = (r/3) * 3;//top left cell of 3x3 box
        int y0 = (c/3) * 3;//top left cell of 3x3 box
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[x0 + i][y0 + j] == x) return false;
            }
        }
        return true;
    }
}
