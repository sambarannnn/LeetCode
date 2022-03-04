class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[query_row+1][query_row+1];
        Double[][] excess_memo = new Double[query_row+1][query_row+1];
        TOP_DOWN_fill(tower, query_row, query_glass, (double)poured, excess_memo);
        return tower[query_row][query_glass];
    }
    public static double TOP_DOWN_fill(double[][] tower, int row, int col, double poured, Double[][] excess_memo) {
    
        if(col < 0 || col > row) {
            return 0.0;
        }
        if(excess_memo[row][col] != null) {
            return excess_memo[row][col];
        }
        if(row == 0) {
            if(poured >= 1.0) {
                tower[row][col] = 1.0;
                return excess_memo[row][col] = poured - 1.0;
            } else {
                tower[row][col] = poured;
                return excess_memo[row][col] = poured;
            }
        }
        double excessFromLeft = TOP_DOWN_fill(tower, row-1, col-1, poured, excess_memo);
        double excessfFromRight = TOP_DOWN_fill(tower, row-1, col, poured, excess_memo);
        double curr = excessFromLeft/2.0 + excessfFromRight/2.0;
        if(curr > 1) {
            tower[row][col] = 1.0;
            double excess = curr - 1.0;
            return excess_memo[row][col] = excess;
        } else {
            tower[row][col] = curr;
            return excess_memo[row][col] = 0.0;
        }
    }
}
// class Solution {
//TLE SOLUTION
//     public double champagneTower(int poured, int query_row, int query_glass) {
//         
//         double[][] tower = new double[101][101];
//         fill(tower, 0, 0, poured, query_row);
//         return tower[query_row][query_glass];
//     }
//     public void fill(double[][] tower, int row, int col, double amount, int maxRow) {
//         if(row > maxRow) {
//             return;//already filled required row
//         }
//         if(col > row) {
//             return;
//         }
//         System.out.println(row + " " + col);
//         double curr = tower[row][col] + amount;
//         double excess = curr - 1.0;
//         if(excess > 0) {
//             tower[row][col] = 1;
//             fill(tower, row+1, col, excess/2.0, maxRow);
//             fill(tower, row+1, col+1, excess/2.0, maxRow);
//         } else {
//             tower[row][col] += amount;
//         }
//     }
// }
