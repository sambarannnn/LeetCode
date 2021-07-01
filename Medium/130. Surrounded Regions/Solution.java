class Solution {
    public void solve(char[][] board) {
        //so we can traverse the boundaries to find Os
        //for every O we find on the boundary, we can do DFS to find all connected Os
        //we mark these O regions(Boundary connected Os) as *
        //now we can safely traverse the entire matrix, turning every O into X(THE BOUNDARY REGIONS HAVE BEEN CONVERTED INTO *)
        //after doing that, we can turn the *s back into Os
        
        
        if (board.length == 0 || board[0].length == 0)
		    return;
	    if (board.length < 2 || board[0].length < 2)//all Os will be boundary only
		    return;
        
        //check first and last columns
        //rowwise go down
        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O')
                DFS(i, 0, board);
            if(board[i][board[0].length-1] == 'O')
                DFS(i, board[0].length-1, board);
        }
        //checking first and last rows
        //columnwise go left to right
        for(int j = 0; j < board[0].length; j++) {
            if(board[0][j] == 'O')
                DFS(0, j, board);
            if(board[board.length-1][j] == 'O')
                DFS(board.length-1, j, board);
        }
        
        //at this point all boundary connected Os are *s
        //so we can safely turn all remaining Os to Xs
        //at the same time, if we encounter a *, we can convert it to O
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    
    private void DFS(int row, int col, char[][] board) {
        if(row < 0 || col < 0 || row > board.length - 1 || col > board[0].length - 1)
            return;
        
        if(board[row][col] == 'O')
            board[row][col] = '*';
        
        //go down if u have a O below
        if(row < board.length - 1 && board[row + 1][col] == 'O')
            DFS(row+1, col, board);
        
        //go up if u have a O above
        if(row > 0 && board[row-1][col] == 'O')
            DFS(row-1, col, board);
        
        //go right if you have a O at right
        if(col < board[0].length - 1 && board[row][col+1] == 'O')
            DFS(row, col+1, board);
        
        //go left if u have a O at left
        if(col > 0 && board[row][col-1] == 'O')
            DFS(row, col-1, board);
    }
}
