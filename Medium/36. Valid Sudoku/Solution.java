class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        //check row
        for(int i = 0; i < rows; i++){
            int check[] = new int[cols + 1];//ignore 0 index
            
            for(int k=0; k < cols; k++){
                if(board[i][k] != '.') {
                    int ele = board[i][k] - '0';  
                    check[ele]++;
                    if(check[ele]>1)//if its repeated
                        return false;
                }
            }
        }
        
        //check column
        for(int i=0; i < cols; i++){
            int check[] = new int[rows + 1];//ignore 0 index
            
            for(int k = 0; k < rows; k++){
                if(board[k][i] != '.'){
                    int ele = board[k][i] - '0';  
                    check[ele - 1]++;
                    if(check[ele - 1]>1)//if it is repeated
                        return false;
                }
            }
        }
        
        //check sub-box
        //total 9 sub-boxes
    //to check boxes w top left from : (0,0); (3,0); (6,0); (0,3); (0,6); (3,3); (3,6); (6,3); (6,6)
        for(int i = 0; i <= 6; i = i+3){
            for(int j = 0; j <= 6; j = j+3){
                int check[] = new int[9 + 1];//9 elements, starting from index 1
                for(int m = i; m < i+3; m++) {
                    for(int n = j; n < j+3; n++) {
                        if(board[m][n] != '.'){
                            int ele = board[m][n] - '0';  
                            check[ele]++;
                            if(check[ele]>1)
                                return false;
                        }
                    }
                }
            }
        }
        return true;
        /*
        HashSet<String> unique = new HashSet<String>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    //identifying each rule (validations)
                    if(!unique.add("row wise : " + i + " : " + board[i][j]) || 
                       !unique.add("column wise : " + j + " : " +board[i][j]) ||
                       !unique.add("grid key : " + i/3 + "-" + j/3 + " : " + board[i][j]))//for each 3x3 grid, i/3 of cells will be equal, same w j/2
                        return false;
                }
            }
        }
        return true;
        */
    }
}
