class Solution {
    //O(m*n)
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer> set = new ArrayList<Integer>();
        //traverse all the rows vertically and store the first rows with occurence of 0
        for(int j = 0; j < mat[0].length; j++) {
            for(int i = 0; i < mat.length; i++) {
                if(mat[i][j] == 0 && (j == 0 || mat[i][j-1] == 1)) {//if this is first 0
                    set.add(i);
                    if(set.size() == k) {
                        break;
                    }
                }
            }
            if(set.size() == k) {
                break;
            }
        }
        //in case we need to count rows with all soldiers too
        if(set.size() < k) {
            int i = 0;
            int j = mat[i].length-1;//just check last column if the row is full of soldiers
            while(set.size() != k) {
                if(mat[i][j] == 1) {
                    set.add(i);
                }
                i++;
            }
        }
        //convert into result array
        int[] res = new int[k];
        int i = 0;
        for(int ele : set) {
            res[i++] = ele;
        }
        return res;
    }
    //O(m*log(max(n, k)) method using custom comparator
//     class rowComparator implements Comparator<int[]> {
//         //comparator for maxheap function
//         @Override
//         public int compare(int[] r1, int[] r2) {
//             if(r1[1] < r2[1]) {
//                 return 1;
//             } else if(r1[1] > r2[1]) {
//                 return -1;
//             } else {
//                 if(r1[0] < r2[0]) {
//                     return 1;
//                 } else {//(r1[0] > r2[0]) 
//                     return -1;
//                 }
//             }
//         }
//     }
//     public int findIndex(int[] row) {
//         //find first index of 0 => number of soldiers
//         int l = 0;
//         int r = row.length-1;
//         while(l <= r) {
//             int mid = l + (r-l)/2;
//             if(row[mid] > 0) {
//                 l = mid+1;
//             } else {
//                 r = mid-1;
//             }
//         }
//         return l;
//     }
    
//     public int[] kWeakestRows(int[][] mat, int k) {
//         //will hold row with max soldiers at root (strongest at root)
//         PriorityQueue<int[]> maxheap = new PriorityQueue<int[]>(new rowComparator());
//         int[] row_details = new int[2];
//         for(int i = 0; i < mat.length; i++) {
//             row_details = new int[2];
//             row_details[0] = i;
//             row_details[1] = findIndex(mat[i]);
//             maxheap.add(row_details);
//             if(maxheap.size()>k){//we have more entries than k
//                 maxheap.remove();//remove the strongest
//             }
//         }
//         int i = k-1;
//         int[] res = new int[k];
//         //out of the k entries we have, strongest is at root
//         //so fill array in reverse order
//         while(!maxheap.isEmpty()) {
//             res[i--] = maxheap.remove()[0];
//         }
//         return res;
//    }
}
