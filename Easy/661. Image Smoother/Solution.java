class Solution {
    public int[][] imageSmoother(int[][] img) {
        
        int rows = img.length;
        int cols = img[0].length;
        int[][] smooth = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                smooth[i][j] = smoothen(img, i, j, rows-1, cols-1);
            }
        }
        return smooth;
    }
    private int smoothen(int[][] img, int row, int col, int rowlen, int collen) {
        
        int rowStart = Math.max(0, row-1);
        int rowEnd = Math.min(rowlen, row+1);
        int colStart = Math.max(0, col-1);
        int colEnd = Math.min(collen, col+1);
        
        int total = 0;
        int count = 0;
        // System.out.println(rowStart + " | " + rowEnd);
        // System.out.println(colStart + " | " + colEnd);
        for(int i = rowStart; i <= rowEnd; i++) {
            for(int j = colStart; j <= colEnd; j++) {
                // System.out.print(img[i][j]);
                total += img[i][j];
                count++;
            }
        }
        // System.out.println();
        return total/count;
    }
}
