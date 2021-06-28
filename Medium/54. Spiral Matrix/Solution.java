class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r1 = 0;
        int c1 = 0;
        int r2 = matrix.length-1;
        int c2 = matrix[0].length-1;
        List<Integer> spiral = new ArrayList<Integer>();
        
        while(r1 <= r2 && c1 <= c2) {
            //System.out.println("ROW WISE 1:");
            for(int j = c1; j <= c2; j++) {
                //System.out.println(matrix[r1][j]);
                spiral.add(matrix[r1][j]);
            }
            //System.out.println();
            //System.out.println("Column WISE 1:");
            for(int i = r1+1; i <= r2; i++) {
                //System.out.println(matrix[i][c2]);
                spiral.add(matrix[i][c2]);
            }
            if(r1 < r2 && c1 < c2) {
                    //System.out.println();
                //System.out.println("ROW WISE 2:");
                for(int j = c2 - 1; j > c1; j--) {
                    //System.out.println(matrix[r2][j]);
                    spiral.add(matrix[r2][j]);
                }
                //System.out.println();
                //System.out.println("Column WISE 2:");
                for(int i = r2; i > r1; i--) {
                    //System.out.println(matrix[i][c1]);
                    spiral.add(matrix[i][c1]);
                }
            }
            //System.out.println();
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return spiral;
    }
}
