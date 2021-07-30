class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int i = 0;
        // while(i <= matrix.length-1) {//top row
        //     for(int j = matrix[i].length-1; j >= 0; j--) {//rightmost col
        //         // System.out.println(matrix[i][j]);
        //         if(matrix[i][j] == target)
        //             return true;
        //         else if(matrix[i][j] < target) {
        //             i++;//next row
        //             break;
        //         } else if(j == 0)//if we reach first index of this row, and we still havent found the ele we are looking for
        //             return false;
        //     }
        // }
        // return false;
        int rows = matrix.length;//3
        int cols = matrix[0].length;//4
        //treat is as a sorted 1D array
        int start = 0;
        int end = rows*cols-1;//last index
        
        while(start <= end) {
            int mid = start+ (end-start)/2;
            int mid_ele = matrix[mid/cols][mid%cols];//as each row has cols no of columns
            
            if(mid_ele == target)
                return true;
            if(mid_ele < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return false;
    }
}
