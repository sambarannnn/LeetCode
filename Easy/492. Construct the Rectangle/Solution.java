// class Solution {
//     public int[] constructRectangle(int area) {
//         int length = 0;
//         int width = 0;
        
//         //length >= width
//         List<int[]> factors = new ArrayList<int[]>();
//         for(int i = 1; i <= area/2; i++) {
//             if(area % i == 0 && i >= area/i) {
//                 factors.add(new int[] {i, area/i});
//             }
//         }
//         factors.add(new int[] {area, 1});
        
//         int[] res = new int[]{Integer.MAX_VALUE, 0};
        
//         for(int[] factor : factors) {
//             if(factor[0]-factor[1] < res[0]-res[1]) {
//                 res[0] = factor[0];
//                 res[1] = factor[1];
//             }
//         }
//         return res;
//     }
// }

class Solution {
    public int[] constructRectangle(int area) {
        int[] res = new int[2];
        int L = area, W = 1;//satisfies L >= W || BUT MAX DIFFERENCE, so lets try reducing the difference
        while(L>=W){
            if(area == L*W){//check if new width, length pair is able to form the area
                res[0] = L;
                res[1] = W;
            }
            W++;//increase width
            L = area/W;//calculate new length
        }
        return res;
    }
}
