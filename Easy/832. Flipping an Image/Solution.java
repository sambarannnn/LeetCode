class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int lo = 0, hi = A[0].length - 1;
            while (lo <= hi) {
                if (A[i][lo] == A[i][hi]) {
                    A[i][lo] = 1 - A[i][lo];
                    A[i][hi] = A[i][lo];
                }
                lo++;
                hi--;
            }
        }
        
        return A;
    }
}
