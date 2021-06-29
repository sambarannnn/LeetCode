class Solution {
    public boolean exist(char[][] board, String word) {
        //for each cell, lets check if the given word can be found from here
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(exist(board, i, j, word, 0)) //initialize length with 0 to start checking with 0th index of word
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int x, int y, String word, int length) {
        
        if(length >= word.length()) //if we have reached this stage, and length has become equal to word length, we have found the word
            return true;
        
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) //if we have moved out of bounds
            return false;
        
        if (board[x][y] == word.charAt(length)) {
            length++;
            char c = board[x][y];
            board[x][y] = '#';//marking it as visited// to ensure we dont come back to same cell during recursive calls
            //check if next char exists at next row/ prev row/ next col/prev col
            boolean res = exist(board, x + 1, y, word, length) || exist(board, x - 1, y, word, length) ||
            exist(board, x, y + 1, word, length) || exist(board, x, y - 1, word, length);
            //removing visited mark
            board[x][y] = c;
            return res;
        }
        //not equal to given char
        return false;
        
    }
}
