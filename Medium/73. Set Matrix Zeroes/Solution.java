class Solution {
    public void setZeroes(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        
        int rowsize = matrix.length;
        int colsize = matrix[0].length;
    
        boolean toprow_haszero = false;
        boolean leftcol_haszero = false;
        
        for(int i = 0; i < rowsize; i++) {
            for(int j = 0; j < colsize; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;//marking this col of topmost row as zero
                    matrix[i][0] = 0;//marking this row of leftmost col as zero
                    //basically we marked the coordinates
                    
                    //in case that 0 element is itself at topmost row or leftmost col
                    if(i == 0)
                        toprow_haszero = true;
                    if(j == 0)
                        leftcol_haszero = true;
                }
            }
        }
        
        //now we can iterate over the topmost row populate reqd zeroes(columnwise)
        for(int j = 1; j < colsize; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 0; i < rowsize; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //now we can iterate over the leftmost col populate reqd zeroes(row wise)
        for(int i = 1; i < rowsize; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 0; j < colsize; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(toprow_haszero == true) {//make the entire row as zero | the corresponding column has been separately taken care of : case 1) it was top row but not leftmost col, so row wise loop must have filled the entire column with zeroes OR case2) it was leftmost col as well, which will be taken care of in next loop(leftcol_haszer0 == true)
            for(int j = 0; j < colsize; j++)
                matrix[0][j] = 0;
        }
        
        if(leftcol_haszero == true) {
            for(int i = 0; i < rowsize; i++)
                matrix[i][0] = 0;
        }
        
        /*
        //SLOW SOLUTION, AND USES EXTRA SPACE
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    set.add("row : " + i);
                    set.add("col : " + j);
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(set.contains("row : " + i) || set.contains("col : " + j)) {
                    matrix[i][j] = 0;
                }
            }
        }
        */
    }
}
