class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index = 0;
        List<int[]> res = new ArrayList<int[]>();
        
        //adding all intervals that come before new interval
        while(index < intervals.length && newInterval[0] > intervals[index][1]) {
            res.add(intervals[index]);
            index++;
        }
        
        //merging new interval
        while(index < intervals.length && newInterval[1] >= intervals[index][0]) {
            newInterval[0]= Math.min(newInterval[0], intervals[index][0]);
            newInterval[1]= Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        res.add(newInterval);
        
        //adding the rest of the intervals
        while(index < intervals.length) {
            res.add(intervals[index]);
            index++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
