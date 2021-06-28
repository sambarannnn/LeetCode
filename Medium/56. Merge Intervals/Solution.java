class Solution {
    public int[][] merge(int[][] intervals) {
        /*
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));//to compare using first element of each int[](pairs)
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        int[][] res = new int[merged.size()][];
        for(int i = 0; i < res.length; i++) {
            res[i] = merged.get(i);    
        }
        return res;
        */
        
        /*
        Given two intervals:
        ----
        a   b
        
             -----
             c   d
        
        After we sort intervals by starts, two intervals overlap if c <= b
        
        To prove:
            Two intervals do not overlap if b < c or d < a; two intervals overlap  if c <= b && a <= d
            If we sort intervals by starts, then a <= c
            Since a <= c and c < d,  a <= d
            So after we sort intervals by starts, two intervals overlap if c <= b
        */
        
        //sorting by start to compare using first element of each int[](pairs)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        Stack<int[]> result = new Stack<>();
        
        for(int[] interval : intervals) {
            if(result.isEmpty())
                result.push(interval);
            else if(result.peek()[1] < interval[0]) {
                result.push(interval);
            } else {
                int temp[] = result.pop();
                temp[1] = Math.max(temp[1], interval[1]);
                result.push(temp);
            }
        }
        int[][] merged = result.toArray(new int[result.size()][]);
        
        // int[][] merged = new int[result.size()][2];
        // for(int i = 0; i < merged.length; i++) {
        //     merged[i] = result.get(i);    
        // }
        return merged;
    }
}
